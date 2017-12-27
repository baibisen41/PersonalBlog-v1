package com.bbs.personalblog.service;

import com.bbs.personalblog.model.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 大森 on 2017/12/9.
 */
public interface INewsCoreService {

/*    public abstract List<News> topNewsList();

    public abstract List<News> showNewsList(int newsType);*/

    public abstract int insertHotNewsList(List<News> newsList);

    public abstract int insertNewNewsList(List<News> newsList);

    public abstract List<News> showTopNewsList();

    public abstract List<News> showHotNewsList();

    public abstract List<News> showNewNewsList();

}
