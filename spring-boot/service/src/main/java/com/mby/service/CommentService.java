package com.mby.service;

import com.mby.model.CommentModel;
import com.mby.model.UserModel;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 11:12
 */

public interface CommentService {

    CommentModel select();

    int update(CommentModel commentModel);

}
