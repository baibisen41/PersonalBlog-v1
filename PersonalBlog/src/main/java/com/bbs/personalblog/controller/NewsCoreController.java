package com.bbs.personalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 大森 on 2017/12/9.
 */
@Controller
public class NewsCoreController {

    //此处爬 http://36kr.com/newsflashes
    @RequestMapping(value = "/shortNews.do", method = RequestMethod.GET)
    public ModelAndView getShortNews() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    //此处爬 https://news.cnblogs.com/
    //有个想法：1.新闻资讯分为中文资讯和英文资讯
    @RequestMapping(value = "/news.do", method = RequestMethod.GET)
    public ModelAndView getNewsList() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

}
