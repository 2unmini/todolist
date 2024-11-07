package com.example.todolist.repository.userrepository;

import com.example.todolist.dto.user.UserRequestDto;
import com.example.todolist.dto.user.UserResponseDto;
import com.example.todolist.entity.User;

import java.util.Optional;

public interface UserRepository {

    UserResponseDto saveUser(User user);

    Optional<User> findUserById(Long id);

    int updateById(Long id, UserRequestDto userRequestDto);

}
