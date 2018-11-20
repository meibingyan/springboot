package com.mby.service;

import com.mby.model.UserModel;

import java.util.Map;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:12
 */

public interface UserService {

    UserModel select();

    int update(UserModel userModel);

    int update2(UserModel userModel);

}
