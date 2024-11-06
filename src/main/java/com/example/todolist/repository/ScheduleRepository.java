package com.example.todolist.repository;

import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Optional<Schedule> findScheduleById(Long id);

    int updateSchedule(Long id, String title, String userName, String content, String password);

    void deleteSchedule(Long id, String password);
}