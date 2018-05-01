package com.bbs.personalblog.businesswork.controller;

import com.bbs.personalblog.businesswork.common.*;
import com.bbs.personalblog.businesswork.service.PbBlogService;
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
 * 博客中心
 * User: baibisen
 * Date: 2018/4/27
 */
@Controller
public class PbBlogController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(PbBlogController.class);

    @Autowired
    private PbBlogService pbBlogService;

    /**
     * 显示主页博客列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/showBlogList")
    public ModelAndView showBlogList(HttpServletRequest request) throws Exception {
        // 1.获取参数
        final String pageNum = getRequestParams(request, "pageNum");
        final String blogType = getRequestParams(request, "blogType");
        // 2.执行service
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("blogType", blogType);
        ModelAndView modelAndView = pbBlogService.getBlogList(map);
        // 3.返回值
        modelAndView.setViewName(ViewRegistration.PB_HOME_BLOG_VIEW);
        return modelAndView;
    }

    @RequestMapping("/showBlogDetail")
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

    // 编辑博客

    /**
     * 文章排行榜
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/showBlogRank")
    public void showBlogRank(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer showBlogCount = Integer.parseInt(getRequestParams(request, "count"));
        if (StringUtils.isEmpty(showBlogCount)) {
            showBlogCount = 5;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("blogCount", showBlogCount);
        response.getWriter().write(pbBlogService.getBlogRank(map).toString());
    }

    // 拉取评论列表

    //资讯
}
