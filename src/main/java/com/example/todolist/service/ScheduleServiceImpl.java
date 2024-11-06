package com.example.todolist.service;

import com.example.todolist.dto.ScheduleRequestDto;
import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import com.example.todolist.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getUserName(), requestDto.getContent(), requestDto.getPassword(), LocalDate.now());
        return scheduleRepository.saveSchedule(schedule); //repository에서 받은 응답데이터를 controller로 전달

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();
        return allSchedules;
    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) { // 받은 @PathVariable id를  repository로 전달
        return scheduleRepository.findScheduleById(id);// repository에서 받은 응답데이터를 controller로 전달

    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) { // 요청 BODY -> Entity로 변환 후 repository로 전달
        if (scheduleRequestDto.getTitle() == null || scheduleRequestDto.getContent() == null || scheduleRequestDto.getPassword() == null) { // 각 값이 null인지 검사
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Schedule schedule = new Schedule(id, scheduleRequestDto.getTitle(), scheduleRequestDto.getUserName(), scheduleRequestDto.getContent(), scheduleRequestDto.getPassword(), LocalDate.now());
        int updateRow = scheduleRepository.updateSchedule(schedule.getScheduleId(), schedule.getTitle(), schedule.getUserName(), schedule.getContent(), schedule.getPassword());
        if (updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // repository에서 응답된 값이 0인지 확인 (0이 아니어야 한다.)
        }
        schedule = scheduleRepository.findScheduleById(id).get(); // 0이 아니라면 id를 repository로 전달 후 그 값을 엔티티로 저장
        return new ScheduleResponseDto(schedule); // entity를 응답데이터로 변환 후 controller로 전달
    }

    @Override
    public void deleteSchedule(Long id, String password) { // 요청 BODY ->  repository로 전달
        scheduleRepository.deleteSchedule(id, password);
    }

}
