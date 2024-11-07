package com.example.todolist.exception;

import org.springframework.http.HttpStatus;

public class NoInformationException extends CustomException {


  @Override
  public int getStatusCode() {
    return HttpStatus.NOT_FOUND.value();
  }

  @Override
  public String getMessage() {
    return "이미 삭제되었거나 없는 정보 입니다";
  }
}
