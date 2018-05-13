package com.bbs.personalblog.dao.dao;

import com.bbs.personalblog.dao.entity.Blog;
import com.bbs.personalblog.dao.entity.Tag;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: baibisen
 * Date: 2018/4/21
 */
@Repository
public interface PbBlogDao {

    List<Blog> selectBlogByType(@Param(value = "blogType") Integer blogType, @Param(value = "pageNum") Integer pageNum) throws Exception;

    List<Tag> selectTagCount() throws Exception;

    Blog selectBlogById(String id) throws Exception;

    List<Blog> selectBlogByCount() throws Exception;
}
