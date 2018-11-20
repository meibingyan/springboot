package com.mby.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.mby.excption.BizException;
import com.mby.lock.DistributedLock;
import com.mby.model.CommentModel;
import com.mby.result.BizResult;
import com.mby.service.CommentService;
import com.mby.transaction.template.ServiceTemplate;
import com.mby.transaction.template.impl.SimpleCallback;
import com.mby.vo.CommentVO;
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
@RequestMapping("comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private ServiceTemplate serviceTemplate;

    @RequestMapping("select")
    public BizResult<CommentVO> select(){
        return serviceTemplate.execute(new SimpleCallback<CommentVO>() {
            @Override
            public void before() {
                super.before();
            }

            @Override
            public CommentVO execute()  {
                CommentModel commentModel = commentService.select();
                CommentVO commentVO = new CommentVO();
                BeanCopier.create(commentModel.getClass(), commentVO.getClass(), true).copy(commentModel, commentVO,
                        (value, targetClz, method) -> {
                            if ((value instanceof Date) && String.class.isAssignableFrom(targetClz)) {
                                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                            }
                            return value;
                        });
                return commentVO;
            }

            @Override
            public void after() {
                super.after();
            }
        });


    }

    @RequestMapping("update")
    public BizResult<Integer> update(CommentModel commentModel){
        return serviceTemplate.execute(new SimpleCallback<Integer>() {

            @Override
            public Integer execute() throws BizException {
                commentModel.setAddTime(new Date());
                return commentService.update(commentModel);
            }

        });
    }


    public static void main(String[] args) {

        DistributedLock lock = new DistributedLock();
        for(int i = 0; i <10; i++) {
            new Thread(() -> {
                for(int j = 0; j <10; j++) {

                    boolean lockFlag = false;
                    try {
                        lockFlag = lock.getLock("xxx" +j);
                        // 让线程睡眠一会 模拟任务执行
                        Thread.sleep(500);
                    } catch (Exception e) {
                        //处理异常
                    } finally {
                        if (lockFlag){
                            lock.releaseLock();
                        }
                    }
                }
            }).start();
        }

    }




}
