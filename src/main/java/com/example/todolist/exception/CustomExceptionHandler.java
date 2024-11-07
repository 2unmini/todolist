package com.example.todolist.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {  // 각 자식들의 만든 에러를 처리하는 핸드러

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(e.getStatusCode()));

    }
}
