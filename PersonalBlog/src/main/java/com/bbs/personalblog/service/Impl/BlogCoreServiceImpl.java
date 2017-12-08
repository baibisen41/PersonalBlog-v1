package com.bbs.personalblog.service.Impl;

import com.bbs.personalblog.dao.IBlogCoreDao;
import com.bbs.personalblog.model.*;
import com.bbs.personalblog.service.IBlogCoreService;
import com.bbs.personalblog.utils.JedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/11/13.
 */
@Service
public class BlogCoreServiceImpl implements IBlogCoreService {

    @Autowired
    private IBlogCoreDao iBlogCoreDao;

    @Resource
    private JedisPool jedisPool;

    @Override
    public Map<String, String> insertBlogDetail(Blog blog) {
        Map<String, String> map = new HashMap<String, String>();
        int resultCode = iBlogCoreDao.insertBlogDetail(blog);
        if (resultCode == 1) {
            System.out.println(200);
            map.put("resultCode", "200");
        } else {
            System.out.println(500);
            map.put("resultCode", "500");
        }
        return map;
    }

    @Override
    public Map<String, String> insertReplyDetail(Reply reply) {
        Map<String, String> map = new HashMap<String, String>();
        int resultCode = iBlogCoreDao.insertReplyDetail(reply);
        if (resultCode == 1) {
            System.out.println(200);
            map.put("resultCode", "200");
        } else {
            System.out.println(500);
            map.put("resultCode", "500");
        }
        return map;
    }

    @Override
    public PageInfo<BlogListPv> showBlogList(int nextPage, int status) {

        //redis放在这里操作
        JedisUtil jedisUtil = JedisUtil.getInstance();

        //将分页操作移到业务层
        PageHelper.startPage(nextPage, 10);

        List<BlogList> blogList = iBlogCoreDao.showBlogList(status);

        //从redis中获取访问量
        List<BlogListPv> blogListPvList = new ArrayList<>();
        BlogListPv blogListPv;
        for (int i = 0; i < blogList.size(); i++) {
            blogListPv = new BlogListPv();
            blogListPv.setBlogId(blogList.get(i).getBlogId());
            blogListPv.setBlogTitle(blogList.get(i).getBlogTitle());
            blogListPv.setBlogLabel(blogList.get(i).getBlogLabel());
            blogListPv.setBlogTime(blogList.get(i).getBlogTime());
            blogListPv.setBlogSimpleContent(blogList.get(i).getBlogSimpleContent());
            blogListPv.setBlogPicUrl(blogList.get(i).getBlogPicUrl());
            blogListPv.setBlogAuthorId(blogList.get(i).getBlogAuthorId());
            blogListPv.setBlogAuthorName(blogList.get(i).getBlogAuthorName());
            //给jedisUtil传一个jedisPool的实例，避免工具类中获取不到实例
            int pv = jedisUtil.get(jedisPool, blogList.get(i).getBlogId()) == null ? 0 : Integer.parseInt(jedisUtil.get(jedisPool, blogList.get(i).getBlogId()));
            blogListPv.setBlogPv(pv);
            blogListPvList.add(blogListPv);
        }

        PageInfo<BlogListPv> pageInfo = new PageInfo<BlogListPv>(blogListPvList);

        return pageInfo;
    }

    @Override
    public Map<String, Object> showBlogDetail(String blogId) {
        Map<String, Object> map = new HashMap<>();

        JedisUtil jedisUtil = JedisUtil.getInstance();
        //给jedisUtil传一个jedisPool的实例，避免工具类中获取不到实例
        int pvCount = jedisUtil.get(jedisPool, blogId) == null ? 0 : Integer.parseInt(jedisUtil.get(jedisPool, blogId));
        pvCount += 1;
        jedisUtil.set(jedisPool, blogId, String.valueOf(pvCount));

        BlogDetail blogDetail = iBlogCoreDao.showBlogDetail(blogId);

        map.put("pvCount", pvCount);
        map.put("blogDetail", blogDetail);
        return map;
    }

    @Override
    public List<ReplyDetail> showReplyDetail(String blogId) {

        List<ReplyDetail> replyDetailList = iBlogCoreDao.showReplyDetail(blogId);

        return replyDetailList;
    }
}
