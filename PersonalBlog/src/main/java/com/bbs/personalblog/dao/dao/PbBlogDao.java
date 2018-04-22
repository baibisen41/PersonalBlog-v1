package com.bbs.personalblog.dao.dao;

import com.bbs.personalblog.dao.entity.Blog;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: baibisen
 * Date: 2018/4/21
 */
@Repository
public interface PbBlogDao {

    List<Blog> selectAllBlogByDate(Integer pageNum, Integer blogType) throws Exception;

    List<Blog> selectTagCount() throws Exception;

    Blog selectBlogById(String id) throws Exception;
}
