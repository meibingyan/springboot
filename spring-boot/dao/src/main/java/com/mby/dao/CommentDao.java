package com.mby.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mby.entity.CommentDO;
import com.mby.entity.UserDO;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:32
 */
@Mapper
public interface CommentDao {

    CommentDO select();

    int update(CommentDO commentDO);
}
