package com.example.todolist.dto;

import com.example.todolist.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
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

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.title = schedule.getTitle();
        this.userName = schedule.getUserName();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(long scheduleId, String title, String userName, String content, LocalDate createdAt, LocalDate updatedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
