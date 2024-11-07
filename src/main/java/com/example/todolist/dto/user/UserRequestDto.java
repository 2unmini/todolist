package com.example.todolist.dto.user;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String userName; // 회원 명
    @Email
    private String email; // 회원 이메일 (email 형식)
}
