package com.bbs.schoolserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 大森 on 2017/11/6.
 */
@RequestMapping("edit")
@Controller
public class BlogEditController {

    @RequestMapping(value = "/editBlogDetail.do", method = RequestMethod.POST)
    public ModelAndView editBlogDetail(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();


        return modelAndView;
    }

}
