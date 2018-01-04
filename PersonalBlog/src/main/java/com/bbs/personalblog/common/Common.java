package com.bbs.personalblog.common;

/**
 * Created by 大森 on 2017/11/16.
 */
public interface Common {

    public final static String successCode = "200";

    public final static String failCode = "500";

    public final static String errorCode = "0";

    public final static int sendStatus = 1;

    public final static int tempStatus = 2;

    /**
     * 爬虫url
     */
    public final static String newsUrl = "https://news.cnblogs.com/";

    public final static String newsHotUrl = "https://news.cnblogs.com/n/digg";

    /**
     * 拉取全部文章来源标识
     */
    public final static int homeFrom = 0;

    public final static int blogListFrom = 1;

    /**
     * 各页面拉取信息标识：home  blog  life
     */
    public final static int blogListFromId = 0;

    public final static int lifeListFromId = 2;

    /**
     * 资讯头条页标识
     */
    public final static int newsNew = 0;

    public final static int newsHot = 1;


}
