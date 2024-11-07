package com.example.todolist.exception;

import org.springframework.http.HttpStatus;

public class mismatchIdException extends CustomException {
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    public String getMessage() {
        return "올바른 ID값이 아닙니다.";
    }
}
// 조회를 위한 id가 올바른 입력값이 아닐때 발생하는 에러
