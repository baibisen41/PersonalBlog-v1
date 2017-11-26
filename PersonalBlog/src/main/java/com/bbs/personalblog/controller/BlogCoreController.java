package com.bbs.personalblog.controller;

import com.bbs.personalblog.common.Common;
import com.bbs.personalblog.model.*;
import com.bbs.personalblog.service.IBlogCoreService;
import com.bbs.personalblog.utils.DateTimeUtil;
import com.bbs.personalblog.utils.IpUtil;
import com.bbs.personalblog.utils.KeyIdUtil;
import com.bbs.personalblog.utils.SimpleContentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大森 on 2017/11/6.
 */
@Controller
public class BlogCoreController {

    private Logger logger = LoggerFactory.getLogger(BlogCoreController.class);

    @Autowired
    private IBlogCoreService iBlogCoreService;

    //博客列表
    @RequestMapping(value = "/showBlogList.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showBlogList() {
        ModelAndView modelAndView = new ModelAndView();
        //拉取全部发布的博客 1->发布；2->草稿
        List<BlogList> bloglist = iBlogCoreService.showBlogList(Common.sendStatus);
        logger.info("total blogs:" + bloglist.size());
        if (bloglist.size() > 0) {
            modelAndView.addObject("blogList", bloglist);
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }

    //博客详情
    @RequestMapping("/showBlogDetail.do")
    public ModelAndView showBlogDetail(@RequestParam("id") String blogId) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("选择博客id:" + blogId);
        BlogDetail blogDetail = iBlogCoreService.showBlogDetail(blogId);
        List<ReplyDetail> replyDetailList = iBlogCoreService.showReplyDetail(blogId);
        for (ReplyDetail replyDetail : replyDetailList) {
            logger.info("回复信息：" + replyDetail.getReplyAuthorName() + ";内容：" + replyDetail.getReplyContent());
        }

        modelAndView.addObject("blogDetail", blogDetail);
        modelAndView.addObject("replyDetail", replyDetailList);
        modelAndView.setViewName("show_blog_detail");
        return modelAndView;
    }

    //编辑
    @RequestMapping(value = "/editBlogDetails.do", method = RequestMethod.POST)
    @ResponseBody
    public Map editBlogDetail(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        Blog blog = new Blog();
        String strTitle = request.getParameter("blog_title_text");
        String strLabel = request.getParameter("blog_label_hidden");
        String strContent = request.getParameter("blog_content_text");
        int sendStatus = Integer.parseInt(request.getParameter("status"));
        logger.info("title=" + strTitle + ";label=" + strLabel + ";content=" + strContent + ";status=" + sendStatus);
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
        String code = iBlogCoreService.insertBlogDetail(blog).get("resultCode").toString();
        logger.info("返回状态码:" + code);

        if (code.equals(Common.successCode)) {
            if (sendStatus == 1) {
                map.put("respStatus", "200");
                map.put("resultView", "temp_select_page.jsp");
            } else if (sendStatus == 2) {
                map.put("respStatus", "200");
                map.put("resultView", "temp_select_page.jsp");
            }
        }
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
