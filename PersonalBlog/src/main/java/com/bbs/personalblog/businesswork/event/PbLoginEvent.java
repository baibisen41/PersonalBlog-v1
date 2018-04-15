package com.bbs.personalblog.businesswork.event;

import com.bbs.personalblog.base.BaseEvent;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录接口
 * User: baibisen
 * Date: 2018/4/14
 */
public class PbLoginEvent extends BaseEvent {

    private HttpServletRequest request;

    public PbLoginEvent(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void resolve() throws Exception {

    }

    @Override
    public ModelAndView execute() throws Exception {
        return null;
    }
}
