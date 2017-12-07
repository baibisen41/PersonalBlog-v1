package com.bbs.personalblog.service.Impl;

import com.bbs.personalblog.dao.IBlogCoreDao;
import com.bbs.personalblog.model.*;
import com.bbs.personalblog.service.IBlogCoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageInfo<BlogList> showBlogList(int nextPage, int status) {

        //将分页操作移到业务层
        PageHelper.startPage(nextPage, 10);

        List<BlogList> blogList = iBlogCoreDao.showBlogList(status);

        PageInfo<BlogList> pageInfo = new PageInfo<BlogList>(blogList);

        return pageInfo;
    }

    @Override
    public BlogDetail showBlogDetail(String blogId) {

        BlogDetail blogDetail = iBlogCoreDao.showBlogDetail(blogId);

        return blogDetail;
    }

    @Override
    public List<ReplyDetail> showReplyDetail(String blogId) {

        List<ReplyDetail> replyDetailList = iBlogCoreDao.showReplyDetail(blogId);

        return replyDetailList;
    }
}
