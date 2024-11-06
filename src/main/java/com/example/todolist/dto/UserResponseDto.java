package com.example.todolist.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String email;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public UserResponseDto(Long id,String userName,String email,LocalDate createdAt){
        this.userId=id;
        this.userName=userName;
        this.email=email;
        this.createdAt=createdAt;
    }

}
