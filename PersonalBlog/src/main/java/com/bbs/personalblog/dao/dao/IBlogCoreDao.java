package com.bbs.personalblog.dao.dao;

import com.bbs.personalblog.dao.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 大森 on 2017/11/13.
 */
@Repository
public interface IBlogCoreDao {

    public abstract int insertBlogDetail(Blog blog);

    public abstract int insertPV(PV pv);

    public abstract int insertReplyDetail(Reply reply);

    public abstract int increaseBlogPv(String id);

    public abstract List<BlogListPv> showBlogList(@Param("from") int from, @Param("status") int status, @Param("fromId") int fromId);

    public abstract List<Tag> showTagList();

    public abstract BlogDetail showBlogDetail(String blogId);

    public abstract List<ReplyDetail> showReplyDetail(String blogId);

    public abstract List<BlogListPv> showLifeList(@Param("fromId") int fromId, @Param("status") int status);

}
