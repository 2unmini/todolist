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
    private String userName; // 작성자명
    private String content;// 내용
    private String password; // 비밀번호
    private LocalDate createdAt; // 등록일시
    private LocalDate updatedAt; // 수정일시

    public Schedule(String title, String userName, String content, String password, LocalDate createdAt) {
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Schedule(long scheduleId, String title, String userName, String content, LocalDate createdAt) {
        this.scheduleId=scheduleId;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
    }
}
