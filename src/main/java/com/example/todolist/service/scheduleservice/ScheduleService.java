package com.example.todolist.service.scheduleservice;

import com.example.todolist.dto.schedule.ScheduleRequestDto;
import com.example.todolist.dto.schedule.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto);

    void deleteSchedule(Long id, String password);

    List<UserScheduleResponseDto> findByPage(int pageNum, int pageSize);

}