package com.example.todolist.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title; //제목
    private Long userId; // user 테이블의 식별자 값
    @NotBlank
    @Size(max = 200)
    private String content; // 할일 (필수값 , 최대길이 200)
    @NotBlank
    private String password; // 비밀번호 (필수값)
}
