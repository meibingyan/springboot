package com.mby.transaction.template.impl;

import com.mby.excption.BizException;
import com.mby.result.BizResult;
import com.mby.transaction.template.ServiceTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service
public class ServiceTemplateImpl implements ServiceTemplate {

    public ServiceTemplateImpl() {
        System.out.println("ServiceTemplateImpl");
    }

    @Resource
   private TransactionTemplate transactionTemplate;

    @Override
    public <T> BizResult<T> execute(SimpleCallback<T> callback) {
        return transactionTemplate.execute((status) -> {
              BizResult<T> result = new BizResult<>();
               try{
                   //前置校验
                   callback.before();
                   //执行
                   result = BizResult.success(callback.execute());

               }catch (BizException e){
                   //记录业务日志
                   result = BizResult.fail();
                   status.setRollbackOnly();

               }finally {
                   try{
                       callback.after();
                   }catch (Exception e){
                       //记录日志
                   }
               }
                return result;
        });
    }
}
