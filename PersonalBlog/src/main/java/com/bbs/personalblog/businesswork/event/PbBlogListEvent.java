package com.bbs.personalblog.businesswork.event;

import com.bbs.personalblog.base.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 拉取博客列表 按时间和热度两种排序方式
 * User: baibisen
 * Date: 2018/4/15
 */
@Component
public class PbBlogListEvent extends BaseEvent {

    private final static Logger logger = LoggerFactory.getLogger(PbBlogListEvent.class);

    private HttpServletRequest request;

    private String blogPageNum;

    public PbBlogListEvent() {
    }

    public PbBlogListEvent(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void resolve() throws Exception {
        blogPageNum = request.getParameter(Keys.BLOG_PAGE_NUM);
        logger.info("event pageNum:{}", blogPageNum);
    }

    @Override
    public ModelAndView execute() throws Exception {
        logger.info("event execute");
//        pbBlogService = AppContext.getBean(PbBlogServiceImpl.class);
//        pbBlogService.getBlogList(this);
        return null;
    }

    private final static class Keys {
        public final static String BLOG_PAGE_NUM = "blogPageNum";
    }

    public String getBlogPageNum() {
        return blogPageNum;
    }
}
