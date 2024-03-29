package com.bbs.personalblog.dao;

import com.bbs.personalblog.model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 大森 on 2017/12/27.
 */
@Repository
public interface INewsCoreDao {

    public abstract int insertHotNewsList(List<News> newsList);

    public abstract int insertNewNewsList(List<News> newsList);

    public abstract List<News> showTopNewsList();

    public abstract List<News> showHotNewsList();

    public abstract List<News> showNewNewsList();

    public abstract News showNewsDetail(@Param("id") String id, @Param("type") int type);

}
