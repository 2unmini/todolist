package com.example.todolist.controller;

import com.example.todolist.dto.ScheduleRequestDto;
import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import com.example.todolist.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ScheduleController {
    ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules") // 일정 생성 요청 API
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.saveSchedule(requestDto);
    }

    @GetMapping("/schedules") // 일정 전체 조회 요청 API
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/schedules/{id}") // 일정 단건 조회 요청 API
    public Optional<Schedule> findScheduleById(@PathVariable Long id) {
        return scheduleService.findScheduleById(id);
    }

    @PutMapping("/schedules/{id}") //일정 수정 요청 API
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto), HttpStatus.OK);

    }

    @DeleteMapping("/schedules/{id}") // 일정 삭제 요청 API
    public void deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.deleteSchedule(id, requestDto.getPassword());
    }

    @GetMapping("/pages")
    public List<UserScheduleResponseDto> findByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return scheduleService.findByPage(page,size);

    }

}
