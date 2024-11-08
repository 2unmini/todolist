package com.example.todolist.repository.schedulerepository;

import com.example.todolist.dto.schedule.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.entity.Paging;
import com.example.todolist.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Optional<Schedule> findScheduleById(Long id);

    int updateSchedule(Long id, String title, Long userId, String content, String password);

    int deleteSchedule(Long id);

    List<UserScheduleResponseDto> findByPage(Paging paging);

    int findPassword(Long id, String password);

}