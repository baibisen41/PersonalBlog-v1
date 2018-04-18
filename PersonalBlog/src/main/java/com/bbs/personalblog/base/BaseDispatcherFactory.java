package com.bbs.personalblog.base;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口工厂
 * User: baibisen
 * Date: 2018/4/14
 */
public abstract class BaseDispatcherFactory {

    public abstract BaseEvent getEventHandler(Integer eventType, HttpServletRequest request) throws Exception;
}
