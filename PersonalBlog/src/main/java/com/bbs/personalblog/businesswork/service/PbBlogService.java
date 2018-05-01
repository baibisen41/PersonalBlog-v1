package com.bbs.personalblog.businesswork.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * User: baibisen
 * Date: 2018/4/15
 */
public interface PbBlogService {

    ModelAndView getBlogList(Map<String, String> map) throws Exception;

    JSONArray getTagList() throws Exception;

    ModelAndView getBlogDetail(Map<String, Object> map) throws Exception;

    JSONArray getBlogRank(Map<String, Object> map) throws Exception;
}
