package com.bbs.personalblog.model;

/**
 * Created by 大森 on 2017/11/13.
 */
public class Blog {

    private String blogId;
    private String blogTitle;
    private String blogLabel;
    private String blogTime;
    private String blogSimpleContent;
    private String blogContent;
    private int sendStatus;
    private String blogPicUrl;
    private String ip;
    private int blogAuthorId;

    public int getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(int blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public int getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getBlogPicUrl() {
        return blogPicUrl;
    }

    public void setBlogPicUrl(String blogPicUrl) {
        this.blogPicUrl = blogPicUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
