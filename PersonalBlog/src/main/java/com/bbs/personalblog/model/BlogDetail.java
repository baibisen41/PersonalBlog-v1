package com.bbs.personalblog.model;

/**
 * Created by 大森 on 2017/11/5.
 */
public class BlogDetail {

    private String blogId;
    private String blogTitle;
    private String blogLabel;
    private String blogTime;
    private int blogAuthorId;
    private String blogAuthorName;
    private String blogDetailContent;
    private String blogPicUrl;

    public String getBlogLabel() {
        return blogLabel;
    }

    public void setBlogLabel(String blogLabel) {
        this.blogLabel = blogLabel;
    }

    public String getBlogPicUrl() {
        return blogPicUrl;
    }

    public void setBlogPicUrl(String blogPicUrl) {
        this.blogPicUrl = blogPicUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogTime() {
        return blogTime;
    }

    public void setBlogTime(String blogTime) {
        this.blogTime = blogTime;
    }

    public int getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(int blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public String getBlogAuthorName() {
        return blogAuthorName;
    }

    public void setBlogAuthorName(String blogAuthorName) {
        this.blogAuthorName = blogAuthorName;
    }

    public String getBlogDetailContent() {
        return blogDetailContent;
    }

    public void setBlogDetailContent(String blogDetailContent) {
        this.blogDetailContent = blogDetailContent;
    }

}
