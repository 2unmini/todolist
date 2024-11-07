package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
@AllArgsConstructor
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
