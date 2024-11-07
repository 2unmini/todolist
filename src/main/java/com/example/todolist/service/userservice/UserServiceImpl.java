package com.example.todolist.service.userservice;

import com.example.todolist.dto.user.UserRequestDto;
import com.example.todolist.dto.user.UserResponseDto;
import com.example.todolist.entity.User;
import com.example.todolist.exception.NoInformationException;
import com.example.todolist.repository.userrepository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달
        User user = new User(userRequestDto.getUserName(), userRequestDto.getEmail(), LocalDate.now()); //등록시간을 LocalDate.now()로 같이 넣어줌
        return userRepository.saveUser(user);
    }

    @Override
    public Optional<User> findUserById(Long id) { // 받은 @PathVariable id를  repository로 전달

        return userRepository.findUserById(id);
    }

    @Override
    public UserResponseDto updateById(Long id, UserRequestDto userRequestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달

        int updateRow = userRepository.updateById(id, userRequestDto); // 데이터베이스에서 쿼리실행 후 가져온 값
        if (updateRow == 0) { // 0이면 정보가 없다는 에러 반환
            throw new NoInformationException();
        }
        Optional<User> user = userRepository.findUserById(id); //있다면 ResponseDto에 넣어 컨트롤러에 반환
        UserResponseDto userResponseDto;
        userResponseDto = new UserResponseDto(user.get());
        return userResponseDto;
    }
}
