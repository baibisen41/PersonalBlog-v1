package com.bbs.personalblog.dao.entity;

/**
 * Created by 大森 on 2017/12/7.
 */
public class BlogListPv {

    private String blogId;
    private String blogTitle;
    private String blogLabel;
    private String blogTime;
    private String blogSimpleContent;
    private String blogPicUrl;
    private int blogAuthorId;
    private String blogAuthorName;
    private int blogPv;
    private int blogFromId;

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

    public String getBlogLabel() {
        return blogLabel;
    }

    public void setBlogLabel(String blogLabel) {
        this.blogLabel = blogLabel;
    }

    public String getBlogTime() {
        return blogTime;
    }

    public void setBlogTime(String blogTime) {
        this.blogTime = blogTime;
    }

    public String getBlogSimpleContent() {
        return blogSimpleContent;
    }

    public void setBlogSimpleContent(String blogSimpleContent) {
        this.blogSimpleContent = blogSimpleContent;
    }

    public String getBlogPicUrl() {
        return blogPicUrl;
    }

    public void setBlogPicUrl(String blogPicUrl) {
        this.blogPicUrl = blogPicUrl;
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

    public int getBlogPv() {
        return blogPv;
    }

    public void setBlogPv(int blogPv) {
        this.blogPv = blogPv;
    }

    public int getBlogFromId() {
        return blogFromId;
    }

    public void setBlogFromId(int blogFromId) {
        this.blogFromId = blogFromId;
    }
}
