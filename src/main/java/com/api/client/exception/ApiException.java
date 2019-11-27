package com.api.client.exception;


public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
  private ApiError error;

  public ApiException(ApiError error) {
    this.error = error;
  }

  public ApiException() {
    super();
  }

  public ApiException(String message) {
    super(message);
  }

  public ApiException(Throwable cause) {
    super(cause);
  }

  public ApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApiError getError() {
    return error;
  }

  @Override
  public String getMessage() {
    if (error != null) {
      return error.getMsg();
    }
    return super.getMessage();
  }
}
