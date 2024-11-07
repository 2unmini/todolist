package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class User {
    private Long userId; // user 테이블의 식별자 값
    private String userName; // 회원 명
    private String email; // 이메일
    private LocalDate createdAt; // 회원 등록 일시
    private LocalDate updatedAt; // 회원 수정 일시

    public User(String userName, String email, LocalDate createdAt) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }
}
