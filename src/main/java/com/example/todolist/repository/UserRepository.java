package com.example.todolist.repository;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserResponseDto saveUser(User user);

    Optional<User> findUserById(Long id);

    int updateUserName(Long id,UserRequestDto userRequestDto);
}
