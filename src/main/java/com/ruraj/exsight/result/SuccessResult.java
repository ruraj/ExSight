package com.ruraj.exsight.result;

/**
 * Created by ruraj on 9/22/16.
 */
public class SuccessResult {
  private Object value;

  public SuccessResult(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return value;
  }
}
