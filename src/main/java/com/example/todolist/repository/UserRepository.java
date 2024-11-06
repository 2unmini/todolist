package com.example.todolist.repository;

import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;

public interface UserRepository {
    UserResponseDto saveUser(User user);
}
