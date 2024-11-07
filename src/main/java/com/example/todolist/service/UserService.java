package com.example.todolist.service;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;

import java.util.Optional;

public interface UserService {
    UserResponseDto saveUser(UserRequestDto userRequestDto);
    Optional<User> findUserById(Long id);
}
