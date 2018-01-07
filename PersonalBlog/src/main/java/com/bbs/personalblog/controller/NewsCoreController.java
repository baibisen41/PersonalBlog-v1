package com.bbs.personalblog.controller;

import com.bbs.personalblog.common.Common;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/12/9.
 */
@Controller
public class NewsCoreController {

    @Autowired
    private INewsCoreService iNewsCoreService;

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

        List<News> shortNewsList = iNewsCoreService.showTopNewsList();

        modelAndView.addObject("hotNewsList", shortNewsList);
        modelAndView.setViewName("temp_side_bar");
        return modelAndView;
    }

    @RequestMapping("/testNews.do")
    @ResponseBody
    public Map<String, Object> testShortNews() {
        Map<String, Object> map = new HashMap<>();
        List<News> shortNewsList = iNewsCoreService.showTopNewsList();
        map.put("data", shortNewsList);
        return map;
    }


    //此处爬 https://news.cnblogs.com/
    @RequestMapping(value = "/news.do", method = RequestMethod.GET)
    public ModelAndView getNewsList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String req = request.getParameter("type");
        String page = request.getParameter("pagenum");
        logger.error("请求类型：" + req + "; 页码：" + page);
        int nextPage, startPage, endPage;
        PageInfo<News> pageInfo = null;
        int newsUrl = 0;

        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");

        List<News> newsList = null;
        if (StringUtils.isEmpty(req)) {

            pageInfo = iNewsCoreService.showNewNewsList(nextPage);
            newsUrl = Common.newsNew;
        } else {
            int newsType = Integer.parseInt(req);
            if (newsType == 1) {
                pageInfo = iNewsCoreService.showHotNewsList(nextPage);
                newsUrl = Common.newsHot;
            }
        }

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

        logger.info("newsUrl:" + newsUrl);
        modelAndView.addObject("newsUrl", newsUrl);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("newsList", pageInfo.getList());
        modelAndView.addObject("totalPages", pageInfo.getPages());
        modelAndView.addObject("nextPages", pageInfo.getPageNum());
        modelAndView.setViewName("show_news_list");
        return modelAndView;
    }

}
