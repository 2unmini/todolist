package com.example.todolist.service;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;

public interface UserService {
    UserResponseDto saveUser(UserRequestDto userRequestDto);
}
