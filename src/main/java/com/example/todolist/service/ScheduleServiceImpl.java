package com.example.todolist.service;

import com.example.todolist.dto.ScheduleRequestDto;
import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import com.example.todolist.exception.NoInformationException;
import com.example.todolist.exception.mismatchIdException;
import com.example.todolist.exception.mismatchPasswordException;
import com.example.todolist.repository.ScheduleRepository;
import com.example.todolist.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleRepository scheduleRepository;
    UserRepository userRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository =userRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getUserId(), requestDto.getContent(), requestDto.getPassword(), LocalDate.now());
        return scheduleRepository.saveSchedule(schedule); //repository에서 받은 응답데이터를 controller로 전달

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleRepository.findAllSchedules();
    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) { // 받은 @PathVariable id를  repository로 전달
        Optional<Schedule> scheduleById = Optional.ofNullable(scheduleRepository.findScheduleById(id).orElseThrow(() -> new mismatchIdException()));
        return scheduleById;// repository에서 받은 응답데이터를 controller로 전달

    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달
        if (scheduleRequestDto.getTitle() == null || scheduleRequestDto.getContent() == null || scheduleRequestDto.getPassword() == null) { // 각 값이 null인지 검사
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        /* if(scheduleRepository.findByPassword(id, scheduleRequestDto.getPassword())==0){
             throw new mismatchPasswordException();
         }*/
        int password = scheduleRepository.findPassword(id, scheduleRequestDto.getPassword());
        if(password==0) {
            throw new mismatchPasswordException();
        }

        Schedule schedule = scheduleRepository.findScheduleById(id).get();
        int updateRow = scheduleRepository.updateSchedule(schedule.getScheduleId(), scheduleRequestDto.getTitle(), scheduleRequestDto.getUserId(), scheduleRequestDto.getContent(), scheduleRequestDto.getPassword());
        if (updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // repository에서 응답된 값이 0인지 확인 (0이 아니어야 한다.)
        }
         schedule = scheduleRepository.findScheduleById(id).get();
        return new ScheduleResponseDto(schedule); // entity를 응답데이터로 변환 후 controller로 전달
    }

    @Override
    public void deleteSchedule(Long id, String password) {// 요청 BODY ->  repository로 전달
        int passwordValues = scheduleRepository.findPassword(id, password);
        /*todo*/

        if(passwordValues==0) {
            throw new mismatchPasswordException();
        }

        if(scheduleRepository.deleteSchedule(id, password)==0){
            throw new NoInformationException();
        }
    }

    @Override
    public List<UserScheduleResponseDto> findByPage(int pageNum, int pageSize) {
        return scheduleRepository.findByPage(pageNum ,pageSize);
    }

}
