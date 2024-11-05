package com.example.todolist.controller;

import com.example.todolist.dto.ScheduleRequestDto;
import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import com.example.todolist.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ScheduleController {
    ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules") // 일정 생성 기능
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.saveSchedule(requestDto);
    }
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }
    @GetMapping("/schedules/{id}")
    public Optional<Schedule> findScheduleById(@PathVariable Long id) {
        return scheduleService.findScheduleById(id);
    }

}
