package com.bbs.personalblog.controller;

import com.bbs.personalblog.model.News;
import com.bbs.personalblog.service.INewsCoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 大森 on 2017/12/9.
 */
@Controller
public class NewsCoreController {

    @Autowired
    private INewsCoreService service;

    private Logger logger = LoggerFactory.getLogger(NewsCoreController.class);

    //此处精选资讯
    @RequestMapping(value = "/shortNews.do", method = RequestMethod.GET)
    public ModelAndView getShortNews() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    //此处爬 https://news.cnblogs.com/
    //有个想法：1.新闻资讯分为中文资讯和英文资讯
    //最新资讯
    @RequestMapping(value = "/news.do", method = RequestMethod.GET)
    public ModelAndView getNewsList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String page = request.getParameter("pagenum");
        int nextPage, startPage, endPage;

        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");
        PageInfo<News> pageInfo = service.showNewsList(nextPage);
        if (pageInfo.getPages() < 6) {
            startPage = 1;
            endPage = pageInfo.getPages();
        } else {
            if (nextPage > 3) {
                startPage = pageInfo.getPageNum() - 3;
                endPage = pageInfo.getPageNum() + 3 > pageInfo.getPages() ? pageInfo.getPages() : pageInfo.getPageNum() + 3;
            } else {
                startPage = 1;
                endPage = pageInfo.getPageNum() + 4;
            }
        }

        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("newsList", pageInfo.getList());
        modelAndView.addObject("totalPages", pageInfo.getPages());
        modelAndView.addObject("nextPages", pageInfo.getPageNum());
        modelAndView.setViewName("show_news_list");
        return modelAndView;
    }

}
