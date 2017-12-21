package com.bbs.personalblog.service.Impl;

import com.bbs.personalblog.model.News;
import com.bbs.personalblog.service.INewsCoreService;
import com.bbs.personalblog.utils.JedisUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大森 on 2017/12/9.
 */
@Service
public class NewsCoreServiceImpl implements INewsCoreService {

    @Resource
    private JedisPool jedisPool;

    @Override
    public PageInfo<News> showNewsList(int nextPage) {
        JedisUtil jedisUtil = JedisUtil.getInstance();

        PageHelper.startPage(nextPage, 3);

        String newsJson = jedisUtil.get(jedisPool, "newsKey");
        List<News> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(newsJson, new TypeReference<List<News>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("资讯页有：" + list.size() + "条");
        PageInfo<News> pageInfo = new PageInfo<News>(list);

        return pageInfo;
    }
}
