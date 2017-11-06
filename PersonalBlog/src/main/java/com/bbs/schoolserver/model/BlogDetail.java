package com.bbs.schoolserver.model;

/**
 * Created by 大森 on 2017/11/5.
 */
public class BlogDetail {

    private String blogId;
    private String blogTitle;
    private String blogTime;
    private int blogAuthorId;
    private String blogAuthorName;
    private String blogDetailContent;
    private String replyId;
    private String replyContent;
    private String replyTime;
    private int replyAuthorId;
    private String replyAuthorName;

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

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public int getReplyAuthorId() {
        return replyAuthorId;
    }

    public void setReplyAuthorId(int replyAuthorId) {
        this.replyAuthorId = replyAuthorId;
    }

    public String getReplyAuthorName() {
        return replyAuthorName;
    }

    public void setReplyAuthorName(String replyAuthorName) {
        this.replyAuthorName = replyAuthorName;
    }
}
