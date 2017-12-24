package com.bbs.personalblog.service;

import com.bbs.personalblog.model.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 大森 on 2017/12/9.
 */
public interface INewsCoreService {

    public abstract List<News> hotNewsList();

    public abstract List<News> showNewsList(int newsType);

}
