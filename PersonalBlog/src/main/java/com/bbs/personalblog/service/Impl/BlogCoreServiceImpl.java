package com.bbs.personalblog.service.Impl;

import com.bbs.personalblog.dao.IBlogCoreDao;
import com.bbs.personalblog.model.*;
import com.bbs.personalblog.service.IBlogCoreService;
import com.bbs.personalblog.utils.JedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by 大森 on 2017/11/13.
 */
@Service
public class BlogCoreServiceImpl implements IBlogCoreService {

    @Autowired
    private IBlogCoreDao iBlogCoreDao;

    @Resource
    private JedisPool jedisPool;

    private Logger logger = LoggerFactory.getLogger(BlogCoreServiceImpl.class);

    @Override
    public Map<String, String> insertBlogDetail(Blog blog) {
        Map<String, String> map = new HashMap<String, String>();
        int resultCode = iBlogCoreDao.insertBlogDetail(blog);
        if (resultCode == 1) {
            logger.info("200");
            map.put("resultCode", "200");
        } else {
            logger.info("500");
            map.put("resultCode", "500");
        }
        return map;
    }

    @Override
    public Map<String, String> insertReplyDetail(Reply reply) {
        Map<String, String> map = new HashMap<String, String>();
        int resultCode = iBlogCoreDao.insertReplyDetail(reply);
        if (resultCode == 1) {
            logger.info("200");
            map.put("resultCode", "200");
        } else {
            logger.info("500");
            map.put("resultCode", "500");
        }
        return map;
    }

    @Override
    public PageInfo<BlogListPv> showBlogList(int nextPage, int from, int status) {

        //redis放在这里操作
        JedisUtil jedisUtil = JedisUtil.getInstance();

        //将分页操作移到业务层
        PageHelper.startPage(nextPage, 3);

        List<BlogListPv> showBlogList = iBlogCoreDao.showBlogList(from, status);
        Collections.sort(showBlogList, new Comparator<BlogListPv>() {
            @Override
            public int compare(BlogListPv o1, BlogListPv o2) {
                //降序
                return o2.getBlogPv() - o1.getBlogPv();
            }
        });

/*        //从redis中获取访问量
        List<BlogListPv> blogListPvList = new ArrayList<>();
        BlogListPv blogListPv;*/
        /**
         * 第一种可能性
         * 找到问题所在了，就是当我获取的blogList是正常的文章列表，里面包含分页的全部信息—>此时分页全是正常的。
         * 但是当我重写blogList后变成blogListPv后，然后放入pageInfo中导致pageHelper以为blogListPv就是全部的文章信息，
         * 导致pageInfo的getPages就始终等于1，也就是我的blogListPv的其中一部分的页数，
         * 后期重改，FUCK!
         **/

        /**
         * 第二种可能性
         * 应该在mybatis级别上进行修改，而不是在service层，这样导致分页无法进行
         */
/*        for (int i = 0; i < blogList.size(); i++) {
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
        }*/
        PageInfo<BlogListPv> pageInfo = new PageInfo<BlogListPv>(showBlogList);

        return pageInfo;
    }

    @Override
    public Map<String, Object> showBlogDetail(String blogId) {
        Map<String, Object> map = new HashMap<>();

/*        JedisUtil jedisUtil = JedisUtil.getInstance();
        //给jedisUtil传一个jedisPool的实例，避免工具类中获取不到实例
        int pvCount = jedisUtil.get(jedisPool, blogId) == null ? 0 : Integer.parseInt(jedisUtil.get(jedisPool, blogId));
        pvCount += 1;
        jedisUtil.set(jedisPool, blogId, String.valueOf(pvCount));*/

        int increaseBlogPv = iBlogCoreDao.increaseBlogPv(blogId);
        if (increaseBlogPv == 1) {
            logger.info("插入访问量成功");
        } else {
            logger.error("插入访问量失败");
        }
        BlogDetail blogDetail = iBlogCoreDao.showBlogDetail(blogId);

//        map.put("pvCount", pvCount);
        map.put("blogDetail", blogDetail);
        return map;
    }

    @Override
    public List<ReplyDetail> showReplyDetail(String blogId) {

        List<ReplyDetail> replyDetailList = iBlogCoreDao.showReplyDetail(blogId);

        return replyDetailList;
    }
}
