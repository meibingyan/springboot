package com.mby.transaction.template;


import com.mby.result.BizResult;
import com.mby.transaction.template.impl.SimpleCallback;

public interface ServiceTemplate {

  <T> BizResult<T> execute(SimpleCallback<T> callback);
}
