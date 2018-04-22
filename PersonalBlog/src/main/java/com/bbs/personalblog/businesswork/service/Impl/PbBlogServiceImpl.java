package com.bbs.personalblog.businesswork.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbs.personalblog.base.BaseServiceImpl;
import com.bbs.personalblog.businesswork.common.Common;
import com.bbs.personalblog.businesswork.result.PbBlogDetailResult;
import com.bbs.personalblog.businesswork.service.PbBlogService;
import com.bbs.personalblog.dao.dao.PbBlogDao;
import com.bbs.personalblog.dao.entity.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 文章相关业务
 * User: baibisen
 * Date: 2018/4/15
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PbBlogServiceImpl extends BaseServiceImpl implements PbBlogService {

    @Autowired
    private PbBlogDao pbBlogDao;

    private final static Logger logger = LoggerFactory.getLogger(PbBlogServiceImpl.class);

    /**
     * 拉取博客列表 暂时都按时间排序
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView getBlogList(Map<String, String> map) throws Exception {
        final Integer blogType = Integer.parseInt(map.get("blogType"));
        Integer pageNum = 1;
        Integer pageStart, pageEnd;
        if (!StringUtils.isEmpty(map.get("pageNum"))) {
            pageNum = Integer.parseInt(map.get("pageNum"));
        }
        PageHelper.startPage(pageNum, 10);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(pbBlogDao.selectAllBlogByDate(pageNum, blogType));
        if (blogPageInfo.getPageSize() <= 6) {
            pageStart = 1;
            pageEnd = 6;
        } else {
            if (blogPageInfo.getPageNum() > 3) {
                pageStart = pageNum - 2;
                pageEnd = pageNum + 2;
            } else {
                pageStart = 1;
                pageEnd = 6;
            }
        }
        ModelAndView resultMap = new ModelAndView();
        resultMap.addObject("pageNum", pageNum);
        resultMap.addObject("pageStart", pageStart);
        resultMap.addObject("pageEnd", pageEnd);
        resultMap.addObject("pageSize", blogPageInfo.getPageSize());
        resultMap.addObject("blogList", blogPageInfo.getList());
        return resultMap;
    }

    @Override
    public JSONArray getTagList() throws Exception {
        return JSONArray.parseArray(JSON.toJSONString(pbBlogDao.selectTagCount()));
    }

    @Override
    public ModelAndView getBlogDetail(Map<String, Object> map) throws Exception {
        final String blogId = String.valueOf(map.get("blogId"));
        Blog blog = pbBlogDao.selectBlogById(blogId);
        PbBlogDetailResult result = new PbBlogDetailResult();
        result.setId(blog.getId());
        result.setTitle(blog.getTitle());
        result.setTag(blog.getTag());
        result.setUserName(blog.getUserName());
        result.setContent(blog.getContent());
        result.setBlogPv(blog.getBlogPv());
        result.setCreateDate(blog.getCreateDate());
        return new ModelAndView().addObject("blogDetail", result);
    }
}
