package com.example.todolist.dto.schedule;

import com.example.todolist.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ScheduleResponseDto {
    private Long scheduleId; // schedule 테이블의 식별자 값
    private String title; //제목
    private Long userId; // user 테이블의 식별자 값
    private String content; // 내용
    private LocalDate createdAt; // 일정 등록일시
    private LocalDate updatedAt; // 일정 수정일시

    public ScheduleResponseDto(long scheduleId, String title, long userId, String content, LocalDate createdAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.title = schedule.getTitle();
        this.userId = schedule.getUserId();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(long scheduleId, String title, long userId, String content, LocalDate createdAt, LocalDate updatedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
