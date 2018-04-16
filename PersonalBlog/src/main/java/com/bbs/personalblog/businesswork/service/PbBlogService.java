package com.bbs.personalblog.businesswork.service;

import com.bbs.personalblog.businesswork.event.PbBlogListEvent;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: baibisen
 * Date: 2018/4/15
 */
public interface PbBlogService {

    ModelAndView getBlogList(PbBlogListEvent event) throws Exception;

}
