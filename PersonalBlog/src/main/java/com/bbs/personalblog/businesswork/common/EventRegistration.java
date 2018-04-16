package com.bbs.personalblog.businesswork.common;

/**
 * 接口注册中心
 * User: baibisen
 * Date: 2018/4/15
 */
public class EventRegistration {

    // 获取文章列表
    public final static Integer PB_GET_ALL_BLOG_EVENT = 0;
    // 获取标签云
    public final static Integer SHOW_TAG_LIST = PB_GET_ALL_BLOG_EVENT + 1;

}
