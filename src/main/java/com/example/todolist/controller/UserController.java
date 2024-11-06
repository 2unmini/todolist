package com.example.todolist.controller;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.saveUser(userRequestDto);

    }
}
