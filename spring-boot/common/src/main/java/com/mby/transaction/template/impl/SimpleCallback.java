package com.mby.transaction.template.impl;


import com.mby.excption.BizException;
import com.mby.transaction.template.CallBack;

public abstract  class SimpleCallback<T> implements CallBack {

    @Override
    public void before() {

    }

    @Override
    public abstract T execute()throws BizException;

    @Override
    public void after() {

    }
}
