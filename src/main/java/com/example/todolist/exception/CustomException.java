package com.example.todolist.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {
    public abstract int getStatusCode();

    public abstract String getMessage();
}
