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
import java.util.List;

/**
 * Created by 大森 on 2017/12/9.
 */
@Controller
public class NewsCoreController {

    @Autowired
    private INewsCoreService service;

    private Logger logger = LoggerFactory.getLogger(NewsCoreController.class);

    /**
     * 热门资讯单独读取前十条存起来，使用率高单独存放
     * 每次侧边栏读取热门资讯都读这里->跳转推荐资讯页
     *
     * @return
     */
    @RequestMapping(value = "/shortNews.do", method = RequestMethod.GET)
    public ModelAndView getShortNews() {
        ModelAndView modelAndView = new ModelAndView();

        List<News> shortNewsList = service.hotNewsList();

        modelAndView.addObject("hotNewsList", shortNewsList);
        modelAndView.setViewName("side_common_bar");
        return modelAndView;
    }

    //此处爬 https://news.cnblogs.com/
    //有个想法：1.新闻资讯分为中文资讯和英文资讯
    //最新资讯
    @RequestMapping(value = "/news.do", method = RequestMethod.GET)
    public ModelAndView getNewsList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String req = request.getParameter("type");
        List<News> newsList = null;
        if (StringUtils.isEmpty(req)) {
            newsList = service.showNewsList(0);
        } else {
            int newsType = Integer.parseInt(req);

            if (newsType == 0) {
                newsList = service.showNewsList(newsType);
            } else if (newsType == 1) {
                newsList = service.showNewsList(newsType);
            }
        }

        modelAndView.addObject("newsList", newsList);
        modelAndView.setViewName("show_news_list");
        return modelAndView;
    }

}
