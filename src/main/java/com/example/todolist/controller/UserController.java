package com.example.todolist.controller;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;
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
    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return userService.saveUser(userRequestDto);

    }
    @GetMapping("/users/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    @PutMapping("/users/{id}")
    public UserResponseDto updateUserName(@PathVariable Long id ,@RequestBody UserRequestDto userRequestDto) {
        return userService.updateUserName(id,userRequestDto);

    }

}
