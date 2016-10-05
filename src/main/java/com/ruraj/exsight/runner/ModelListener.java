package com.ruraj.exsight.runner;

import java.lang.reflect.Method;

/**
 * Created by ruraj on 9/22/16.
 */
public interface ModelListener {
  void onClassAdded(Class clazz);
  void onMethodAdded(Class clazz, Method method);
}
