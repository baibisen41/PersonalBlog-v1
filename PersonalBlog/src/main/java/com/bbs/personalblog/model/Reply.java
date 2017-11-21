package com.bbs.personalblog.model;

/**
 * Created by 大森 on 2017/11/20.
 */
public class Reply {

    private String replyId;
    private String replyContent;
    private String replyTime;
    private String replyIp;
    private String replyBlogId;
    private int replyAuthorId;

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

    public String getReplyIp() {
        return replyIp;
    }

    public void setReplyIp(String replyIp) {
        this.replyIp = replyIp;
    }

    public String getReplyBlogId() {
        return replyBlogId;
    }

    public void setReplyBlogId(String replyBlogId) {
        this.replyBlogId = replyBlogId;
    }

    public int getReplyAuthorId() {
        return replyAuthorId;
    }

    public void setReplyAuthorId(int replyAuthorId) {
        this.replyAuthorId = replyAuthorId;
    }
}
