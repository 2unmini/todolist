package com.example.todolist.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
public class ScheduleRequestDto {
    private String title; //제목
    private Long userId; // 작성자명
    @NotBlank
    @Size(max=200)
    private String content; // 할일
    @NotBlank
    private String password; // 비밀번호
}
