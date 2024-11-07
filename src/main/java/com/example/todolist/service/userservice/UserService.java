package com.example.todolist.service.userservice;

import com.example.todolist.dto.user.UserRequestDto;
import com.example.todolist.dto.user.UserResponseDto;
import com.example.todolist.entity.User;

import java.util.Optional;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto userRequestDto);

    Optional<User> findUserById(Long id);

    UserResponseDto updateById(Long id, UserRequestDto userRequestDto);

}
