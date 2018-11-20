package com.mby.model;

import java.util.Date;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 14:51
 */
public class UserModel {

    private Integer id;

    private String name;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserModel() {
    }

    private UserModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder{

        Integer id;

        String name;

        Date updateTime;

        Date createTime;


        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public UserModel build(){
            return new UserModel(this);
        }

    }




}
