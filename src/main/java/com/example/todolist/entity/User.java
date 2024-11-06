package com.example.todolist.entity;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class User {
    private Long userId;
    private String userName;
    private String email;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public User(String userName,String email,LocalDate createdAt){
        this.userName=userName;
        this.email=email;
        this.createdAt=createdAt;
    }
}
