package com.example.todolist.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title; //제목
    private Long userId; // 작성자명
    private String content; // 내용
    private String password; // 비밀번호
}
