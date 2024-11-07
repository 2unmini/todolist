package com.example.todolist.service;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getUserName(), userRequestDto.getEmail(), LocalDate.now());
        return userRepository.saveUser(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {

        return userRepository.findUserById(id);
    }
}
