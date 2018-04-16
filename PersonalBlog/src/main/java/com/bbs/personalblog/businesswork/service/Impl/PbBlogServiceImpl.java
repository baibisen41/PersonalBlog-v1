package com.bbs.personalblog.businesswork.service.Impl;

import com.bbs.personalblog.businesswork.event.PbBlogListEvent;
import com.bbs.personalblog.businesswork.service.PbBlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文章相关业务
 * User: baibisen
 * Date: 2018/4/15
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PbBlogServiceImpl implements PbBlogService {

    private final static Logger logger = LoggerFactory.getLogger(PbBlogServiceImpl.class);

    /**
     * 拉取博客列表 按时间和热度排序
     *
     * @param event
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView getBlogList(PbBlogListEvent event) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        final Integer blogPageNum = Integer.parseInt(event.getBlogPageNum());
        logger.info("service blogPageNum:{}", blogPageNum);
        return modelAndView;
    }
}
