package com.example.todolist.dto.user;

import com.example.todolist.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    private Long userId; // user 테이블의 식별자 값
    private String userName; // 회원 명
    private String email; // 회원 이메일
    private LocalDate createdAt; // 회원 등록 일시
    private LocalDate updatedAt; // 회원 수정 일시

    public UserResponseDto(Long id, String userName, String email, LocalDate createdAt) {
        this.userId = id;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = LocalDate.now();
    }

}
