package com.mby.entity;

import java.util.Date;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 14:40
 */
public class CommentDO {

    private Integer id;

    private Integer userId;

    private String content;

    private Date addTime;

    private Date lastModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

}
