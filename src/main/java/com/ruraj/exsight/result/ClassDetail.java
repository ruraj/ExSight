package com.ruraj.exsight.result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruraj on 9/22/16.
 */
public class ClassDetail {
  private Class clazz;

  private List<MethodDetail> methodDetails = new ArrayList<>();

  public ClassDetail(Class clazz) {
    this.clazz = clazz;
  }

  public Class getClazz() {
    return clazz;
  }

  public List<MethodDetail> getMethodDetails() {
    return methodDetails;
  }

  public void addMethodDetail(MethodDetail methodDetail) {
    methodDetails.add(methodDetail);
  }
}
