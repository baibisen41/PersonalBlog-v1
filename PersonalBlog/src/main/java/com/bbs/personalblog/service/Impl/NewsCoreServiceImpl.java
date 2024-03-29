package com.bbs.personalblog.service.Impl;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.dao.INewsCoreDao;
import com.bbs.personalblog.model.News;
import com.bbs.personalblog.service.INewsCoreService;
import com.bbs.personalblog.utils.JedisUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/12/9.
 */
@Service
public class NewsCoreServiceImpl implements INewsCoreService {

    @Resource
    private JedisPool jedisPool;

    @Autowired
    private INewsCoreDao iNewsCoreDao;

    private Logger logger = LoggerFactory.getLogger(NewsCoreServiceImpl.class);

    @Override
    public int insertHotNewsList(List<News> newsList) {

        logger.info("hotNews插入数量:" + newsList.size());
        int result = iNewsCoreDao.insertHotNewsList(newsList);
        logger.info("插入结果:" + result);
        return result;
    }

    @Override
    public int insertNewNewsList(List<News> newsList) {

        logger.info("hotNews插入数量:" + newsList.size());
        int result = iNewsCoreDao.insertNewNewsList(newsList);
        logger.info("标识位flag");
        logger.info("插入结果:" + result);
        return result;
    }

    @Override
    public List<News> showTopNewsList() {
        List<News> list = iNewsCoreDao.showTopNewsList();
        return list;
    }

    @Override
    public PageInfo<News> showHotNewsList(int nextPage) {

        PageHelper.startPage(nextPage, 15);

        List<News> list = iNewsCoreDao.showHotNewsList();

        PageInfo<News> pageInfo = new PageInfo<News>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<News> showNewNewsList(int nextPage) {

        PageHelper.startPage(nextPage, 20);

        List<News> list = iNewsCoreDao.showNewNewsList();

        PageInfo<News> pageInfo = new PageInfo<News>(list);
        return pageInfo;
    }

    @Override
    public Map<String, Object> showNewsDetail(String newsId, int type) {
        Map<String, Object> map = new HashMap<>();

        News newsDetail = iNewsCoreDao.showNewsDetail(newsId, type);

//        map.put("pvCount", pvCount);
        map.put("newsDetail", newsDetail);
        return map;
    }


/*    @Override
    public List<News> topNewsList() {
        JedisUtil jedisUtil = JedisUtil.getInstance();
        String newsJson = null;

        if (jedisUtil.get(jedisPool, "topNewsKey") != null) {
            newsJson = jedisUtil.get(jedisPool, "topNewsKey");
            logger.info(newsJson);
        } else {
            //如果主页短资讯为空，则去取出全部热门资讯，获取前10条存储

        }

        List<News> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(newsJson, new TypeReference<List<News>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("资讯页有：" + list.size() + "条");

        return list;
    }

    @Override
    public List<News> showNewsList(int newsType) {
        JedisUtil jedisUtil = JedisUtil.getInstance();
        String newsJson = null;

        if (newsType == Common.newsNew) {
            newsJson = jedisUtil.get(jedisPool, "newNewsKey");
            logger.info("newsNew");
        } else if (newsType == Common.newsHot) {
            newsJson = jedisUtil.get(jedisPool, "hotNewsKey");
            logger.info("newsHot");
        } else {
            logger.error("error");
        }

        List<News> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(newsJson, new TypeReference<List<News>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("资讯页有：" + list.size() + "条");

        return list;
    }*/
}
