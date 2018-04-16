package com.bbs.personalblog.businesswork.common;

import com.bbs.personalblog.base.BaseDispatcherFactory;
import com.bbs.personalblog.base.BaseEvent;
import com.bbs.personalblog.businesswork.event.PbBlogListEvent;
import com.bbs.personalblog.businesswork.event.PbLoginEvent;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller 和 Event 连接中心
 * User: baibisen
 * Date: 2018/4/14
 */
public class DispatcherFactory extends BaseDispatcherFactory {

    private BaseEvent baseEvent = null;

    //搭建接口工厂
    public ModelAndView getEventHandler(Integer eventType, HttpServletRequest request) throws Exception {
        switch (eventType) {
            case 0:
                baseEvent = new PbBlogListEvent(request);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        return getModelAndView(baseEvent);
    }

    private ModelAndView getModelAndView(BaseEvent baseEvent) throws Exception {

        return baseEvent.execute();
    }
}
