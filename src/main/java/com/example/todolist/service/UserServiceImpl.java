package com.example.todolist.service;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;
import com.example.todolist.exception.NoInformationException;
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

    @Override
    public UserResponseDto updateUserName(Long id,UserRequestDto userRequestDto) {
        int updateRow = userRepository.updateUserName(id,userRequestDto);
        if(updateRow==0){
            throw new NoInformationException();
        }
        Optional<User>user = userRepository.findUserById(id);
        UserResponseDto userResponseDto;
        userResponseDto = new UserResponseDto(user.get());
        return userResponseDto ;
    }
}
