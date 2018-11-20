package com.mby.transaction.template;


import com.mby.excption.BizException;

public interface CallBack<T> {

    void before();

    T execute() throws BizException;

    void after();


}
