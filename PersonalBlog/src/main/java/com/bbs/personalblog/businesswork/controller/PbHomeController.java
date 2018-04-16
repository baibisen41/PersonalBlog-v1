package com.bbs.personalblog.businesswork.controller;

import com.bbs.personalblog.businesswork.common.Common;
import com.bbs.personalblog.businesswork.common.DispatcherFactory;
import com.bbs.personalblog.businesswork.common.EventRegistration;
import com.bbs.personalblog.dao.entity.BlogListPv;
import com.bbs.personalblog.dao.entity.News;
import com.bbs.personalblog.dao.entity.Tag;
import com.bbs.personalblog.businesswork.service.IBlogCoreService;
import com.bbs.personalblog.businesswork.service.INewsCoreService;
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
import java.util.*;

/**
 * Created by 大森 on 2017/12/22.
 */
@Controller
public class PbHomeController {

    private Logger logger = LoggerFactory.getLogger(PbHomeController.class);

    /**
     * 显示主页博客列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/home")
    public ModelAndView showHomeView(HttpServletRequest request) throws Exception {

        logger.info("controller");

        return new DispatcherFactory().getEventHandler(EventRegistration.PB_GET_ALL_BLOG_EVENT, request);
/*        ModelAndView modelAndView = new ModelAndView();
        String page = request.getParameter("pagenum");
        int nextPage, startPage, endPage;

        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");

        *//**
         * 主页的博客列表通过pv来进行排序
         * 目前的想法是在mybatis写两个显示方法
         * 一个通过pv给主页排序，一个通过时间给博客列表排序
         *//*
        PageInfo<BlogListPv> pageInfo = iBlogCoreService.showBlogList(nextPage, Common.homeFrom, Common.sendStatus, Common.blogListFromId);

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
        List<News> shortNewsList = iNewsCoreService.showTopNewsList();
        logger.info("推荐资讯数量：" + shortNewsList.size());
//        List<News> shortNewsList = new ArrayList<>();
        //第三部分站长统计

        //第四部分 小功能---前台完成

        logger.info("总页数：" + pageInfo.getPages());
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("blogList", pageInfo.getList());
        modelAndView.addObject("totalPages", pageInfo.getPages());
        modelAndView.addObject("nextPages", pageInfo.getPageNum());
        modelAndView.addObject("hotNewsList", shortNewsList);
        modelAndView.setViewName("home");*/
    }

/*    @RequestMapping(value = "/showTagList.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Tag>> showTagList() {
        Map<String, List<Tag>> map = new HashMap<>();
        List<Tag> tagList = iBlogCoreService.showTagList();
        logger.debug("tag size:" + tagList.size());
        map.put("tagMap", tagList);
        return map;
    }*/

    /**
     * 标签云
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/showTagList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showTagList(HttpServletRequest request) throws Exception {
        return new DispatcherFactory().getEventHandler(EventRegistration.SHOW_TAG_LIST, request);
    }
}
