package com.ruraj.exsight.result;

import com.ruraj.exsight.result.FailureResult;
import com.ruraj.exsight.result.SuccessResult;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruraj on 9/22/16.
 */
public class InputSet {

  private boolean isSuccess = false;

  private FailureResult failureResult;
  private SuccessResult successResult;

  private Map<Parameter, Object> parameterValueMap = new HashMap<>();

  public void setParameterValue(Parameter parameter, Object value) {
    parameterValueMap.put(parameter, value);
  }

  public Map<Parameter, Object> getParameterValueMap() {
    return parameterValueMap;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public FailureResult getFailureResult() {
    return failureResult;
  }

  public void setFailureResult(FailureResult failureResult) {
    this.failureResult = failureResult;
  }

  public SuccessResult getSuccessResult() {
    return successResult;
  }

  public void setSuccessResult(SuccessResult successResult) {
    this.successResult = successResult;
  }
}
