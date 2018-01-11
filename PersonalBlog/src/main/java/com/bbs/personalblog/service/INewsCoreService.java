package com.bbs.personalblog.service;

import com.bbs.personalblog.model.News;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/12/9.
 */
public interface INewsCoreService {

/*    public abstract List<News> topNewsList();

    public abstract List<News> showNewsList(int newsType);*/

    public abstract int insertHotNewsList(List<News> newsList);

    public abstract int insertNewNewsList(List<News> newsList);

    public abstract List<News> showTopNewsList();

    public abstract PageInfo<News> showHotNewsList(int nextPage);

    public abstract PageInfo<News> showNewNewsList(int nextPage);

    public abstract Map<String, Object> showNewsDetail(String newsId, int type);

}
