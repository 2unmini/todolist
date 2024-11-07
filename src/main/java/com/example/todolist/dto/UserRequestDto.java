package com.example.todolist.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String userName;
    @Email
    private String email;
}
