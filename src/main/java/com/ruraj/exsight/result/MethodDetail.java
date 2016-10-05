package com.ruraj.exsight.result;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruraj on 9/22/16.
 */
public class MethodDetail {
  private List<MethodDetail> parents = new ArrayList<>();
  private List<MethodDetail> children = new ArrayList<>();

  private List<InputSet> inputSetList = new ArrayList<>();
  private List<List<Object>> inputSetListTemp = new ArrayList<>();

  private Method method;

  public MethodDetail(Method method) {
    this.method = method;
  }

  public Method getMethod() {
    return method;
  }

  public void addParent(MethodDetail methodDetail) {
    parents.add(methodDetail);
  }

  public void addChild(MethodDetail methodDetail) {
    children.add(methodDetail);
  }

  public List<MethodDetail> getParents() {
    return parents;
  }

  public List<MethodDetail> getChildren() {
    return children;
  }

  public boolean hasParents() {
    return parents.size() > 0;

  }

  public boolean hasChildren() {
    return children.size() > 0;
  }

  public void addInputSet(InputSet inputSet) {
    inputSetList.add(inputSet);
  }

  public void addInputSetTemp(List<Object> objects) {
    inputSetListTemp.add(objects);
  }

  public List<InputSet> getInputSetList() {
    return inputSetList;
  }

  public List<List<Object>> getInputSetListTemp() {
    return inputSetListTemp;
  }
}
