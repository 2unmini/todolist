package com.example.todolist.service;

import com.example.todolist.dto.ScheduleRequestDto;
import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import com.example.todolist.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

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
}
