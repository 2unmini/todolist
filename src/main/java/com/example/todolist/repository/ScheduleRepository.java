package com.example.todolist.repository;

import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Optional<Schedule> findScheduleById(Long id);

    int updateSchedule(Long id, String title, Long userId, String content, String password);

    void deleteSchedule(Long id, String password);

    List<UserScheduleResponseDto> findByPage(int pageNum, int pageSize);

}