package com.mby.service;

import com.mby.model.UserModel;

import java.util.Map;

/**
 * @author ex_meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:12
 */

public interface UserService {

    Map<String, Object> select();

    int update(UserModel userModel);

}
