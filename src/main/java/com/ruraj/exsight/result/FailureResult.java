package com.ruraj.exsight.result;

/**
 * Created by ruraj on 9/22/16.
 */
public class FailureResult {
  private Throwable throwable;

  public FailureResult(Throwable throwable) {
    this.throwable = throwable;
  }

  public Throwable getThrowable() {
    return throwable;
  }
}
