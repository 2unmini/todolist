package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Schedule {
    private Long scheduleId; // schedule 테이블의 식별자 값
    private String title; //제목
    private Long userId; // user 테이블의 식별자 값
    private String content;// 내용
    private String password; // 비밀번호
    private LocalDate createdAt; // 일정 등록일시
    private LocalDate updatedAt; // 일정 수정일시

    public Schedule(String title, long userId, String content, String password, LocalDate createdAt) {
        this.title = title;
        this.userId = userId;
        this.content = content;
        this.password = password;
        this.createdAt = createdAt;
    }

}
