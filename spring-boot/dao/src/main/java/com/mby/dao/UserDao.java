package com.mby.dao;

import java.util.Map;

import com.mby.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ex_meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:32
 */
@Mapper
public interface UserDao {

    Map<String, Object> select();

    int update(UserDO userDO);
}
