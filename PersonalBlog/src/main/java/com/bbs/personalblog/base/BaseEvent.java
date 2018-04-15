package com.bbs.personalblog.base;

import org.springframework.web.servlet.ModelAndView;


/**
 * 接口基类
 * User: baibisen
 * Date: 2018/4/14
 */
public abstract class BaseEvent {

    // 请求解析方法
    public abstract void resolve() throws Exception;

    // 请求执行方法
    public abstract ModelAndView execute() throws Exception;
}
