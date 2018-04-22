package com.bbs.personalblog.businesswork.controller;

import com.bbs.personalblog.base.BaseController;
import com.bbs.personalblog.businesswork.common.*;
import com.bbs.personalblog.businesswork.service.PbBlogService;
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
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by 大森 on 2017/12/22.
 */
@Controller
public class PbHomeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(PbHomeController.class);

    @Autowired
    private PbBlogService pbBlogService;

    /**
     * 显示主页博客列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public ModelAndView showHomeView(HttpServletRequest request) throws Exception {
        // 1.获取参数
        final String pageNum = getRequestParams(request, "pageNum");
//        final String blogType = getRequestParams(request, "blogType");
        // 2.执行service
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("blogType", String.valueOf(Common.blogAllType));
        ModelAndView modelAndView = pbBlogService.getBlogList(map);
        // 3.返回值
        modelAndView.setViewName(ViewRegistration.PB_HOME_BLOG_VIEW);
        return modelAndView;
    }

    @RequestMapping("/showBlogDetail.do")
    public ModelAndView showBlogDetail(HttpServletRequest request) throws Exception {
        final String blogId = getRequestParams(request, "id");
        logger.info("选择博客id:" + blogId);

        Map<String, Object> map = new HashMap<>();
        map.put("blogId", blogId);
        //访问量 + 文章详情
        ModelAndView modelAndView = pbBlogService.getBlogDetail(map);
        modelAndView.setViewName(ViewRegistration.PB_BLOG_DETAIL);
        return modelAndView;
    }

    /**
     * 标签云
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/showTagList", method = RequestMethod.GET)
    @ResponseBody
    public void showTagList(HttpServletResponse response) throws Exception {
        response.getWriter().write(pbBlogService.getTagList().toString());
    }
}
