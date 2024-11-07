package com.example.todolist.dto;

import com.example.todolist.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
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
    public UserResponseDto(User user) {
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.email = user.getEmail();
        this.createdAt=user.getCreatedAt();
        this.updatedAt=LocalDate.now();
    }

}
