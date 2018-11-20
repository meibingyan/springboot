package com.mby.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import com.mby.dao.CommentDao;
import com.mby.entity.CommentDO;
import com.mby.model.CommentModel;
import com.mby.service.CommentService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mby.dao.UserDao;
import com.mby.entity.UserDO;
import com.mby.model.UserModel;
import com.mby.service.UserService;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:13
 */
@Service

public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public CommentModel select() {
        CommentDO commentDO = commentDao.select();
        CommentModel commentModel = new CommentModel();
        if(commentDO==null){
            return commentModel;
        }
        BeanCopier.create(CommentDO.class, commentModel.getClass(), false).copy(commentDO, commentModel, null);
        return commentModel;
    }

    @Override
    public int update(CommentModel commentModel) {
        if (commentModel == null) {
            throw new RuntimeException("commentModel is null");
        }
        CommentDO commentDO = new CommentDO();
        BeanCopier.create(commentModel.getClass(), commentDO.getClass(), false).copy(commentModel, commentDO, null);

        int update = commentDao.update(commentDO);

        return update;
    }


}
