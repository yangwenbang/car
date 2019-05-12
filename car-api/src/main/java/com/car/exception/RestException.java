package com.car.exception;

public class RestException extends Exception {
  public RestException(String msg) {
    super(msg);
  }

  public RestException(String msg, Throwable e) {
    super(msg, e);
  }
}
