package com.bbs.personalblog.businesswork.controller;

import com.bbs.personalblog.businesswork.common.Common;
import com.bbs.personalblog.businesswork.common.DispatcherFactory;
import com.bbs.personalblog.dao.entity.*;
import com.bbs.personalblog.businesswork.service.IBlogCoreService;
import com.bbs.personalblog.framework.utils.*;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * User: baibisen
 * Date: 2018/4/14
 */
@Controller
public class PbBlogController {

    private Logger logger = LoggerFactory.getLogger(PbBlogController.class);

    @Autowired
    private IBlogCoreService iBlogCoreService;

    //博客列表
    @RequestMapping(value = "/showBlogList.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showBlogList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
/*        String page = request.getParameter("pagenum");
        int nextPage, startPage, endPage;

        if (StringUtils.isEmpty(page)) {
            nextPage = 1;
        } else {
            nextPage = Integer.parseInt(page);
        }
        logger.info("翻到第" + nextPage + "页");

        //拉取全部发布的博客 1->发布；2->草稿
        PageInfo<BlogListPv> pageInfo = iBlogCoreService.showBlogList(nextPage, Common.blogListFrom, Common.sendStatus, Common.blogListFromId);

        for (int i = 0; i < pageInfo.getList().size(); i++) {
            logger.info("get content from:" + pageInfo.getList().get(i).getBlogFromId());
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


        logger.info("total blogs:" + pageInfo.getList().size());
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        modelAndView.addObject("blogList", pageInfo.getList());
        modelAndView.addObject("totalPages", pageInfo.getPages());
        modelAndView.addObject("nextPages", pageInfo.getPageNum());
//        modelAndView.addObject("labelList", labelSet);
        modelAndView.setViewName("show_blog_list");*/
        return modelAndView;
    }

    //详情
//    @RequestMapping("/showBlogDetail.do")
//    public ModelAndView showBlogDetail(@RequestParam("id") String blogId) {
//        ModelAndView modelAndView = new ModelAndView();
//        logger.info("选择博客id:" + blogId);
//
//        //访问量 + 文章详情
//        Map<String, Object> map = iBlogCoreService.showBlogDetail(blogId);
//
//        List<ReplyDetail> replyDetailList = iBlogCoreService.showReplyDetail(blogId);
//        for (ReplyDetail replyDetail : replyDetailList) {
//            logger.info("回复信息：" + replyDetail.getReplyAuthorName() + ";内容：" + replyDetail.getReplyContent());
//        }
//
////        modelAndView.addObject("blogDetailPv", map.get("pvCount"));
//        modelAndView.addObject("blogDetail", map.get("blogDetail"));
//        modelAndView.addObject("blogDetailFlag", Common.blogDetailFlag);
//        modelAndView.addObject("replyDetail", replyDetailList);
//        modelAndView.setViewName("show_blog_detail");
//        return modelAndView;
//    }

    //编辑
    @RequestMapping(value = "/editBlogDetails.do", method = RequestMethod.POST)
    @ResponseBody
    public Map editBlogDetail(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
/*        Blog blog = new Blog();
        PV pv = new PV();
        String strTitle = request.getParameter("blog_title_text");
        String strLabel = request.getParameter("blog_label_hidden");
        String strContent = request.getParameter("blog_content_text");
        int sendStatus = Integer.parseInt(request.getParameter("status"));
        int fromId = Integer.parseInt(request.getParameter("blog_from_id"));
        logger.info("title=" + strTitle + ";label=" + strLabel + ";content=" + strContent + ";status=" + sendStatus + ";fromid=" + fromId);
        String strBlogId = KeyIdUtil.getId();
        String strSimpleContent = SimpleContentUtil.getSimpleContent(strContent);
        String strBlogTime = DateTimeUtil.getDateHandler(System.currentTimeMillis());
        String strIp = IpUtil.getIp(request, response);
        String strPicUrl = "";
        logger.info("BlogId=" + strBlogId + ";SimpleContent=" + strSimpleContent + ";BlogTime=" + strBlogTime + ";PicUrl=" + strPicUrl + ";IP=" + strIp + ";status=" + sendStatus);
        blog.setBlogId(strBlogId);
        blog.setBlogTitle(strTitle);
        blog.setBlogLabel(strLabel);
        blog.setBlogTime(strBlogTime);
        blog.setBlogSimpleContent(strSimpleContent);
        blog.setBlogContent(strContent);
        blog.setSendStatus(sendStatus);
        blog.setBlogPicUrl(strPicUrl);
        blog.setIp(strIp);
        blog.setBlogAuthorId(2013082401);
        blog.setBlogFromId(fromId);
        String code = iBlogCoreService.insertBlogDetail(blog).get("resultCode").toString();
        logger.info("返回状态码:" + code);

        pv.setBlogId(strBlogId);
        String pvCode = iBlogCoreService.insertPV(pv).get("resultCode").toString();
        logger.info("注册pv返回码：" + pvCode);

        if (code.equals(Common.successCode)) {
            if (sendStatus == 1) {
                map.put("respStatus", "200");
                map.put("resultView", "home.jsp");
            } else if (sendStatus == 2) {
                map.put("respStatus", "200");
                map.put("resultView", "home.jsp");
            }
        }*/
        return map;
    }

    //  评论区
    @RequestMapping("/editReplyDetail.do")
    public String editReplyDetail(HttpServletRequest request, HttpServletResponse response) {
        String replyContent = request.getParameter("reply_text");
        String getBlogId = request.getParameter("reply_hidden");
        System.out.println("发出的评论：" + replyContent);
        Reply reply = new Reply();
        reply.setReplyId(KeyIdUtil.getId());
        reply.setReplyContent(replyContent);
        reply.setReplyTime(DateTimeUtil.getDateHandler(System.currentTimeMillis()));
        reply.setReplyIp(IpUtil.getIp(request, response));
        reply.setReplyAuthorId(2013121112);
        reply.setReplyBlogId(getBlogId);

        String resultCode = iBlogCoreService.insertReplyDetail(reply).get("resultCode");
        System.out.println("回复返回码：" + resultCode);
        return "redirect:/showBlogDetail.do?id=" + getBlogId;
    }

}
