package com.mby.vo;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 14:52
 */
public class CommentVO {

    private Integer id;

    private Integer userId;

    private String content;

    private String addTime;

    private String lastModify;

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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getLastModify() {
        return lastModify;
    }

    public void setLastModify(String lastModify) {
        this.lastModify = lastModify;
    }
}
