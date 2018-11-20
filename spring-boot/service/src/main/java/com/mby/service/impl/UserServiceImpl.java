package com.mby.service.impl;

import java.util.Date;

import com.mby.dao.CommentDao;
import com.mby.entity.CommentDO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mby.dao.UserDao;
import com.mby.entity.UserDO;
import com.mby.model.UserModel;
import com.mby.service.UserService;

import javax.annotation.Resource;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:13
 */
@Service

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("sssss");
    }

    @Resource
    private UserDao userDao;

    @Resource
    private CommentDao commentDao;

    @Resource
    private ApplicationContext applicationContext;


    @Override
    public UserModel select() {
        UserDO userDO = userDao.select();
        UserModel userModel = new UserModel();
        BeanCopier.create(userDO.getClass(), userModel.getClass(), false).copy(userDO, userModel, null);

        return userModel;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int update(UserModel userModel) {
        if (userModel == null) {
            throw new RuntimeException("userModel is null");
        }

        UserDO userDO = new UserDO();
        BeanCopier.create(userModel.getClass(), userDO.getClass(), false).copy(userModel, userDO, null);
        userDO.setCreateTime(new Date());
        int update = userDao.update(userDO);

        UserService userService = applicationContext.getBean(getClass());
        userService.update2(userModel);

        //int i = 10/0;
        return update;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int update2(UserModel userModel) {

//        UserDO userDO = new UserDO();
//        BeanCopier.create(userModel.getClass(), userDO.getClass(), false).copy(userModel, userDO, null);
//        userDO.setUpdateTime(new Date());
//        int update = userDao.update(userDO);
        CommentDO commentDO = new CommentDO();
        commentDO.setId(1);
        commentDO.setLastModify(new Date());
        int update = commentDao.update(commentDO);

        return update;
    }
}
