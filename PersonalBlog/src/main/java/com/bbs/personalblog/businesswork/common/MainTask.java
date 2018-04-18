package com.bbs.personalblog.businesswork.common;

import com.bbs.personalblog.base.BaseEvent;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * User: baibisen
 * Date: 2018/4/18
 */
public class MainTask {

    // event接口主要执行方法
    public ModelAndView mainEventHandler(Integer eventType, HttpServletRequest request) throws Exception {
        BaseEvent baseEvent = new DispatcherFactory().getEventHandler(eventType, request);
        baseEvent.resolve();
        ModelAndView modelAndView = baseEvent.execute();
        return modelAndView;
    }
}
