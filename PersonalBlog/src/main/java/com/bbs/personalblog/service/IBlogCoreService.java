package com.bbs.personalblog.service;

import com.bbs.personalblog.model.*;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/11/13.
 */
public interface IBlogCoreService {

    public abstract Map<String, String> insertBlogDetail(Blog blog);

    public abstract Map<String, String> insertPV(PV pv);

    public abstract Map<String, String> insertReplyDetail(Reply reply);

    public abstract PageInfo<BlogListPv> showBlogList(int nextPage, int form, int status, int fromId);

    public abstract List<Tag> showTagList();

    public abstract Map<String, Object> showBlogDetail(String blogId);

    public abstract List<ReplyDetail> showReplyDetail(String blogId);

    public abstract PageInfo<BlogListPv> showLifeList(int nextPage, int status);

}
