package com.example.todolist.exception;


public abstract class CustomException extends RuntimeException {
    public abstract int getStatusCode();

    public abstract String getMessage();
}
