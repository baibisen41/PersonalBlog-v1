package com.bbs.personalblog.dao;

import com.bbs.personalblog.model.Blog;
import com.bbs.personalblog.model.BlogDetail;
import com.bbs.personalblog.model.BlogList;
import com.bbs.personalblog.model.ReplyDetail;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 大森 on 2017/11/13.
 */
@Repository
public interface IBlogCoreDao {

    public abstract int insertBlogDetail(Blog blog);

    public abstract int insertReplyDetail(ReplyDetail reply);

    public abstract List<BlogList> showBlogList(int status);

    public abstract BlogDetail showBlogDetail(String blogId);

    public abstract ReplyDetail showReplyDetail(String blogId);

}
