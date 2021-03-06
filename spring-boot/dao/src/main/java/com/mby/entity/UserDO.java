package com.mby.entity;

import java.util.Date;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 14:40
 */
public class UserDO {

    private Integer id;

    private String name;

    private Date updateTime;

    private Date createTime;

    public UserDO() {
        System.out.println("userDO");
    }

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
}
