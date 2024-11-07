package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserScheduleResponseDto {
    private Long scheduleId; // schedule 테이블의 식별자 값
    private String title; // 제목
    private Long userId; // user 테이블의 작성자 고유 아이디
    private String username; // 회원 명
    private String content; // 내용
    private LocalDate createdAt; // 회원 등록일시
    private LocalDate updatedAt; // 회원 수정일시
}
