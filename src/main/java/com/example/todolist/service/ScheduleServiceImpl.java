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
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getUserName(), requestDto.getContent(), requestDto.getPassword(), LocalDate.now());
        return scheduleRepository.saveSchedule(schedule);

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();
        return allSchedules;
    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) {
        return scheduleRepository.findScheduleById(id);

    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id,ScheduleRequestDto scheduleRequestDto) {
        if(scheduleRequestDto.getTitle()==null || scheduleRequestDto.getContent()==null||scheduleRequestDto.getPassword()==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Schedule schedule =new Schedule(id,scheduleRequestDto.getTitle(),scheduleRequestDto.getUserName(),scheduleRequestDto.getContent(),scheduleRequestDto.getPassword(),LocalDate.now());
        int updateRow = scheduleRepository.updateSchedule(schedule.getScheduleId(),schedule.getTitle(),schedule.getUserName(),schedule.getContent(),schedule.getPassword());
        if(updateRow==0){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        schedule=scheduleRepository.findScheduleById(id).get();
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id ,String password) {
        scheduleRepository.deleteSchedule(id,password);
    }

}
