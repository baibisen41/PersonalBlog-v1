package com.bbs.personalblog.controller;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.model.BlogListPv;
import com.bbs.personalblog.service.IBlogCoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 大森 on 2018/1/3.
 */
@Controller
public class LifeCoreController {

    private Logger logger = LoggerFactory.getLogger(LifeCoreController.class);

    @Autowired
    private IBlogCoreService iBlogCoreService;

    @RequestMapping(value = "/showLifeList.do")
    public ModelAndView showLifeList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String page = request.getParameter("pagenum");
        int nextPage, startPage, endPage;
        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");

        PageInfo<BlogListPv> lifePageInfo = iBlogCoreService.showLifeList(nextPage, Common.sendStatus);

        for (int i = 0; i < lifePageInfo.getList().size(); i++) {
            logger.info("get content from:" + lifePageInfo.getList().get(i).getBlogFromId());
        }

        if (lifePageInfo.getPages() < 6) {
            startPage = 1;
            endPage = lifePageInfo.getPages();
        } else {
            if (nextPage > 3) {
                startPage = lifePageInfo.getPageNum() - 3;
                endPage = lifePageInfo.getPageNum() + 3 > lifePageInfo.getPages() ? lifePageInfo.getPages() : lifePageInfo.getPageNum() + 3;
            } else {
                startPage = 1;
                endPage = lifePageInfo.getPageNum() + 4;
            }
        }
        logger.info("total blogs:" + lifePageInfo.getList().size());
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("blogList", lifePageInfo.getList());
        modelAndView.addObject("totalPages", lifePageInfo.getPages());
        modelAndView.addObject("nextPages", lifePageInfo.getPageNum());
        modelAndView.setViewName("show_life_list");
        return modelAndView;
    }
}
