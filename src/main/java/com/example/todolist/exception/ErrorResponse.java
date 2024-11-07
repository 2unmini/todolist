package com.example.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse { // 오류 코드와 오류 메시지를 저장하는 Response 객체
    private int errorCode; // 오류 코드
    private String message; // 오류 메시지
}
