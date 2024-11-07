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
