package com.example.todolist.exception;

import org.springframework.http.HttpStatus;

public class mismatchPasswordException extends CustomException {

    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    public String getMessage() {
        return "비밀번호가 일치 하지 않습니다.";
    }
}
// 저장된 일정의 비밀번호와 일치하지 않을때 발생하는 에러