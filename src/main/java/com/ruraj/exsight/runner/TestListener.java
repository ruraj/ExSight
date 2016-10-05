package com.ruraj.exsight.runner;

import com.ruraj.exsight.result.InputSet;
import com.ruraj.exsight.result.MethodDetail;

/**
 * Created by ruraj on 9/22/16.
 */
public interface TestListener {
  void onSuccess(Class clazz, MethodDetail methodDetail, InputSet inputSet);
  void onError(Class clazz, MethodDetail methodDetail, InputSet inputSet);
}
