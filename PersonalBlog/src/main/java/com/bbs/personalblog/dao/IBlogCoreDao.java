package com.bbs.personalblog.dao;

import com.bbs.personalblog.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 大森 on 2017/11/13.
 */
@Repository
public interface IBlogCoreDao {

    public abstract int insertBlogDetail(Blog blog);

    public abstract int insertReplyDetail(Reply reply);

    public abstract List<BlogList> showBlogList(int status);

    public abstract BlogDetail showBlogDetail(String blogId);

    public abstract List<ReplyDetail> showReplyDetail(String blogId);

}
