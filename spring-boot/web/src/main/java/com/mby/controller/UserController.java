package com.mby.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mby.model.UserModel;
import com.mby.service.UserService;
import com.mby.vo.UserVO;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 10:41
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("select")
    public UserVO select(){
        UserModel userModel = userService.select();
        UserVO userVO = new UserVO();
        BeanCopier.create(userModel.getClass(), userVO.getClass(), true).copy(userModel, userVO,
                (value, targetClz, method) -> {
                    if ((value instanceof Date) && String.class.isAssignableFrom(targetClz)) {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                    }
                    return value;
                });
        return userVO;
    }

    @RequestMapping("update")
    public int update(UserModel userModel){

        return userService.update(userModel);
    }

}
