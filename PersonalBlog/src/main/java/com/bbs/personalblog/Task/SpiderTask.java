package com.bbs.personalblog.Task;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.model.News;
import com.bbs.personalblog.service.INewsCoreService;
import com.bbs.personalblog.utils.DateTimeUtil;
import com.bbs.personalblog.utils.JedisUtil;
import com.bbs.personalblog.utils.SpecialWordUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by 大森 on 2017/12/10.
 */
@Component
public class SpiderTask {

    private static Logger logger = LoggerFactory.getLogger(SpiderTask.class);

    private static volatile boolean isFinish = false;

    @Autowired
    private INewsCoreService iNewsCoreService;

    @Resource
    private JedisPool jedisPool;

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void startFake() {
        logger.info("假定时任务");
    }

    //由于现在数据量不大，可以每两个小时重新抓取一次，并存储，如果后期爬取数据量大的网站再进行优化
    public void startSpiderHandler() {
        List<News> newsList = new ArrayList<>();

        //临时改成同步
        int i = saveContentHandler(0, spiderNewHandler());
        logger.info("存储结果：" + i);

        int j = saveContentHandler(1, spiderHotHandler());
        logger.info("存储结果：" + i);

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                saveContentHandler(0, spiderNewHandler());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                saveContentHandler(1, spiderHotHandler());
            }
        }).start();*/
    }

    private Map<String, List<News>> spiderNewHandler() {
        Map<String, List<News>> map = new HashMap<>();
        List<News> newsList = new ArrayList<>();
        News news = null;

        //获取全部文章 共计3000条，下一页根据规律仿写url
        ok:
        for (int i = 1; i <= 17; i++) {
            Document document = null;
            if (i == 1) {
                document = getDocument(Common.newsUrl);
            } else {
                document = getDocument(Common.newsUrl + "/n/page/" + i + "/");
            }

            //抓取标题
            Elements elementsTitle = document.getElementsByClass("news_entry");
            //抓取时间
            Elements elementsTime = document.getElementsByClass("entry_footer");
            //内容概述
            Elements elementsSummary = document.getElementsByClass("entry_summary");
            //内容详情链接
            Elements elementsContent = document.select("div.content").select("h2");
            for (int j = 0; j < elementsTitle.size(); j++) {
                news = new News();
                String time = elementsTime.get(j).select("span.gray").text();
//                if (DateTimeUtil.revertHandler("2017-12-13 00:00") > DateTimeUtil.revertHandler(time))
//                    break ok;//只获取本周的新鲜资讯
                if (DateTimeUtil.isNeedStopSpiderHandler(time))
                    break ok;

                //获取内容详情链接，再次访问该链接，并获取内容详情
                String contentUrl = elementsContent.get(j).getElementsByTag("a").attr("href");
                Document docContent = getDocument(Common.newsUrl + contentUrl);

/*                logger.info((j + 1) + "标题：" + elementsTitle.get(j).text());
                logger.info((j + 1) + "时间：" + elementsTime.get(j).select("span.gray").text());
                logger.info((j + 1) + "描述：" + elementsSummary.get(j).text());
                logger.info((j + 1) + "内容：" + docContent.select("#news_body").select("p").text() + "\n");*/

                news.setNewsTitle(elementsTitle.get(j).text());
                news.setNewsTime(elementsTime.get(j).select("span.gray").text());
                news.setNewsFrom("博客园");
                news.setNewsSummary(SpecialWordUtil.filterEmoji(elementsSummary.get(j).text()));
                news.setNewsContent(SpecialWordUtil.filterEmoji(docContent.select("#news_body").select("p").text()));
                newsList.add(news);
            }
        }
        map.put("newNewsMapKey", newsList);
        return map;
    }

    private Map<String, List<News>> spiderHotHandler() {
        Map<String, List<News>> map = new HashMap<>();
        List<News> newsList = new ArrayList<>();
        List<News> topNewsList = new ArrayList<>();
        News news = null;
        int count = 0;

        //获取全部文章 共计3000条，下一页根据规律仿写url
        for (int i = 1; i <= 27; i++) {
            Document document = null;
            if (i == 1) {
                document = getDocument(Common.newsHotUrl);
            } else {
                document = getDocument(Common.newsHotUrl + "?page=" + i);
            }

            //抓取标题
            Elements elementsTitle = document.getElementsByClass("news_entry");
            //抓取时间
            Elements elementsTime = document.getElementsByClass("entry_footer");
            //内容概述
            Elements elementsSummary = document.getElementsByClass("entry_summary");
            //内容详情链接
            Elements elementsContent = document.select("div.content").select("h2");
            for (int j = 0; j < elementsTitle.size(); j++) {
                news = new News();
                //获取内容详情链接，再次访问该链接，并获取内容详情
                String contentUrl = elementsContent.get(j).getElementsByTag("a").attr("href");
                Document docContent = getDocument(Common.newsUrl + contentUrl);

/*                logger.info((j + 1) + "标题：" + elementsTitle.get(j).text());
                logger.info((j + 1) + "时间：" + elementsTime.get(j).select("span.gray").text());
                logger.info((j + 1) + "描述：" + elementsSummary.get(j).text());
                logger.info((j + 1) + "内容：" + docContent.select("#news_body").select("p").text() + "\n");*/

                news.setNewsTitle(elementsTitle.get(j).text());
                news.setNewsTime(elementsTime.get(j).select("span.gray").text());
                news.setNewsFrom("博客园");
                news.setNewsSummary(SpecialWordUtil.filterEmoji(elementsSummary.get(j).text()));
                news.setNewsContent(SpecialWordUtil.filterEmoji(docContent.select("#news_body").select("p").text()));
                newsList.add(news);

/*                if (count < 10 && i == 1) {
                    topNewsList.add(news);
                    count++;
                    logger.error("计数器：" + count);
                }*/
            }
        }
//        map.put("topNewsMapKey", topNewsList);
        map.put("hotNewsMapKey", newsList);
        return map;
    }

    /**
     * 思路：获取主页侧边10条热门资讯
     * 截取爬取的全部热门资讯的前10条，通过Map封装两部分，分别是Top10和全部热门
     * 在封装成json及存储在redis前进行判断，是来自热门资讯还是最新资讯
     * 判断完成后再进行封装和存储
     * <p>
     * 业务写的有点繁琐，不清晰，后期优化
     *
     * @param from
     * @param newsMap
     * @return
     */
    private synchronized int saveContentHandler(int from, Map<String, List<News>> newsMap) {
        int saveResultCode = 0;
        try {
            logger.error("本次处理来自：" + from + " 的请求");
            ObjectMapper objectMapper = new ObjectMapper();
            JedisUtil jedisUtil = JedisUtil.getInstance();

            if (from == 0) {
/*                if (!StringUtils.isEmpty(newsMap.get("newNewsMapKey"))) {
                    String newNewsJson = objectMapper.writeValueAsString(newsMap.get("newNewsMapKey"));
                    logger.info("来自最新资讯的封装jon:" + newNewsJson);
                    logger.error("本次最新资讯总计爬取了：" + newsMap.get("newNewsMapKey").size() + "条");
                    if (!StringUtils.isEmpty(jedisUtil.get(jedisPool, "newNewsKey"))) {
                        jedisUtil.del(jedisPool, "newNewsKey");
                    }
                    jedisUtil.set(jedisPool, "newNewsKey", newNewsJson);
                }*/
                int result = iNewsCoreService.insertNewNewsList(newsMap.get("newNewsMapKey"));
                logger.info("SpiderTask插入最新资讯结果：" + result);
            } else {
/*                if (!StringUtils.isEmpty(newsMap.get("topNewsMapKey"))) {
                    String topNewsJson = objectMapper.writeValueAsString(newsMap.get("topNewsMapKey"));
                    logger.info("来自热门资讯前10条的封装jon:" + topNewsJson);
                    logger.error("本次总计爬取了：" + newsMap.get("topNewsMapKey").size() + "条");
                    if (!StringUtils.isEmpty(jedisUtil.get(jedisPool, "topNewsKey"))) {
                        jedisUtil.del(jedisPool, "topNewsKey");
                    }
                    jedisUtil.set(jedisPool, "topNewsKey", topNewsJson);
                } else {
                    logger.info("爬取数据为空");
                }

                if (!StringUtils.isEmpty(newsMap.get("hotNewsMapKey"))) {
                    String hotNewsJson = objectMapper.writeValueAsString(newsMap.get("hotNewsMapKey"));
                    logger.info("来自热门资讯全部的封装jon:" + hotNewsJson);
                    logger.error("本次总计爬取了：" + newsMap.get("hotNewsMapKey").size() + "条");
                    if (!StringUtils.isEmpty(jedisUtil.get(jedisPool, "hotNewsKey"))) {
                        jedisUtil.del(jedisPool, "hotNewsKey");
                    }
                    jedisUtil.set(jedisPool, "hotNewsKey", hotNewsJson);
                } else {
                    logger.info("爬取数据为空");
                }*/
                int result = iNewsCoreService.insertHotNewsList(newsMap.get("hotNewsMapKey"));
                logger.info("SpiderTask插入最新资讯结果：" + result);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            saveResultCode = 1;
        }
        return saveResultCode;
    }

    public static void main(String[] args) {
        new SpiderTask().startSpiderHandler();
    }

}
