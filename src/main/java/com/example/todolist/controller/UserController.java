package com.example.todolist.controller;

import com.example.todolist.dto.user.UserRequestDto;
import com.example.todolist.dto.user.UserResponseDto;
import com.example.todolist.entity.User;
import com.example.todolist.service.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users") // 회원 생성 요청 API
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.saveUser(userRequestDto);

    }

    @GetMapping("/users/{id}") // 회원 조회 요청 API
    public Optional<User> findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/users/{id}") // 회원 수정 요청 API
    public UserResponseDto updateById(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateById(id, userRequestDto);

    }

}
