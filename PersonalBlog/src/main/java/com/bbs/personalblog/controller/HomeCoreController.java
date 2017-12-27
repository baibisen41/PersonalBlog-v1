package com.bbs.personalblog.controller;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.model.BlogListPv;
import com.bbs.personalblog.model.News;
import com.bbs.personalblog.service.IBlogCoreService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大森 on 2017/12/22.
 */
@Controller
public class HomeCoreController {

    private Logger logger = LoggerFactory.getLogger(HomeCoreController.class);

    @Autowired
    private IBlogCoreService iBlogCoreService;

    @Autowired
    private INewsCoreService iNewsCoreService;

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public ModelAndView showHome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String page = request.getParameter("pagenum");
        int nextPage, startPage, endPage;

        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");

        /**
         * 主页的博客列表通过pv来进行排序
         * 目前的想法是在mybatis写两个显示方法
         * 一个通过pv给主页排序，一个通过时间给博客列表排序
         */
        PageInfo<BlogListPv> pageInfo = iBlogCoreService.showBlogList(nextPage, Common.homeFrom, Common.sendStatus);

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

        //第二部分 每日资讯
//        List<News> shortNewsList = iNewsCoreService.showTopNewsList();
//        logger.info("推荐资讯数量：" + shortNewsList.size());
        List<News> shortNewsList = new ArrayList<>();
        //第三部分站长统计

        //第四部分 小功能---前台完成

        logger.info("总页数：" + pageInfo.getPages());
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("blogList", pageInfo.getList());
        modelAndView.addObject("totalPages", pageInfo.getPages());
        modelAndView.addObject("nextPages", pageInfo.getPageNum());
        modelAndView.addObject("hotNewsList", shortNewsList);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
