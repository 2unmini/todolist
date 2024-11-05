package com.example.todolist.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ScheduleResponseDto {
    private Long scheduleId; // schedule 테이블의 식별자 값
    private String title; //제목
    private String userName; // 작성자명
    private String content; // 내용
    private LocalDate createdAt; // 등록일시
    private LocalDate updatedAt; // 수정일시

    public ScheduleResponseDto(long scheduleId, String title, String userName, String content, LocalDate createdAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
    }
}
