package com.mby.web;

import com.mby.model.UserModel;
import com.mby.service.UserService;
import com.mby.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * @author ex_meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 10:41
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("select")
    public Map<String, Object> select(){
        return userService.select();
    }

    @RequestMapping("update")
    public int update(UserModel userModel){
        userModel.setUpdateTime(new Date());
        userModel.setCreateTime(new Date());
        return userService.update(userModel);
    }

}
