package com.bbs.personalblog.Task;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.model.News;
import com.bbs.personalblog.utils.DateTimeUtil;
import com.bbs.personalblog.utils.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 大森 on 2017/12/10.
 */
@Component
public class SpiderTask {

    private static Logger logger = LoggerFactory.getLogger(SpiderTask.class);

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

    //由于现在数据量不大，可以每两个小时重新抓取一次，并存储，如果后期爬取数据量大的网站再进行优化
    public void startSpiderHandler() {
        List<News> newsList = new ArrayList<>();
        News news = null;
        //获取全部文章 共计3000条，下一页根据规律仿写url
        ok:
        for (int i = 1; i <= 100; i++) {
            Document document = null;
            if (i == 1) {
                document = getDocument(Common.newsUrl);
            } else {
                document = getDocument(Common.newsUrl + "/n/page/" + i + "/");
            }
            news = new News();

            //抓取标题
            Elements elementsTitle = document.getElementsByClass("news_entry");
            //抓取时间
            Elements elementsTime = document.getElementsByClass("entry_footer");
            //内容概述
            Elements elementsSummary = document.getElementsByClass("entry_summary");
            //内容详情链接
            Elements elementsContent = document.select("div.content").select("h2");
            for (int j = 0; j < elementsTitle.size(); j++) {

                String time = elementsTime.get(j).select("span.gray").text();
//                if (DateTimeUtil.revertHandler("2017-12-13 00:00") > DateTimeUtil.revertHandler(time))
//                    break ok;//只获取本周的新鲜资讯
                if (DateTimeUtil.isNeedStopSpiderHandler(time))
                    break ok;

                //获取内容详情链接，再次访问该链接，并获取内容详情
                String contentUrl = elementsContent.get(j).getElementsByTag("a").attr("href");
                Document docContent = getDocument(Common.newsUrl + contentUrl);

                logger.info("标题：" + elementsTitle.get(j).text());
                logger.info("时间：" + elementsTime.get(j).select("span.gray").text());
                logger.info("描述：" + elementsSummary.get(j).text());
                logger.info("内容：" + docContent.select("#news_body").select("p").text() + "\n");

                news.setNewsTitle(elementsTitle.get(j).text());
                news.setNewsTime(elementsTime.get(j).select("span.gray").text());
                news.setNewsFrom("博客园");
                news.setNewsSummary(elementsSummary.get(j).text());
                news.setNewsContent(docContent.select("#news_body").select("p").text());
            }
            newsList.add(news);
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String resultJson = objectMapper.writeValueAsString(newsList);
            logger.info("封装jon:" + resultJson);
            JedisUtil jedisUtil = JedisUtil.getInstance();
            jedisUtil.set(jedisPool, "newsKey", resultJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private int saveContentHandler() {
        int saveResultCode = 0;
        return saveResultCode;
    }

    public static void main(String[] args) {
        new SpiderTask().startSpiderHandler();
    }

}
