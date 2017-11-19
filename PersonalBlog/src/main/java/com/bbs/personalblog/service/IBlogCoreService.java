package com.bbs.personalblog.service;

import com.bbs.personalblog.model.Blog;
import com.bbs.personalblog.model.BlogDetail;
import com.bbs.personalblog.model.BlogList;
import com.bbs.personalblog.model.ReplyDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/11/13.
 */
public interface IBlogCoreService {

    public abstract Map<String, String> insertBlogDetail(Blog blog);

    public abstract Map<String, String> insertReplyDetail(ReplyDetail reply);

    public abstract List<BlogList> showBlogList(int status);

    public abstract BlogDetail showBlogDetail(String blogId);

    public abstract ReplyDetail showReplyDetail(String blogId);

}
