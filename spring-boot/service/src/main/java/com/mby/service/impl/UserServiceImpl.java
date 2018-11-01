package com.mby.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mby.dao.UserDao;
import com.mby.entity.UserDO;
import com.mby.model.UserModel;
import com.mby.service.UserService;

import javax.annotation.Resource;

/**
 * @author ex_meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:13
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Map<String, Object> select() {
        return userDao.select();
    }

    @Override
    public int update(UserModel userModel) {
        if (userModel == null) {
            throw new RuntimeException("userModel is null");
        }
        UserDO userDO = new UserDO();
        BeanCopier.create(userModel.getClass(), userDO.getClass(), false).copy(userModel, userDO, null);
        int update = userDao.update(userDO);
        return update;
    }
}
