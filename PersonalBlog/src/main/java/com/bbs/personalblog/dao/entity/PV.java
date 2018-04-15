package com.bbs.personalblog.dao.entity;

/**
 * Created by 大森 on 2018/1/5.
 */
public class PV {

    private String blogId;
    private int blogPv;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public int getBlogPv() {
        return blogPv;
    }

    public void setBlogPv(int blogPv) {
        this.blogPv = blogPv;
    }
}
