package com.example.todolist.controller;

import com.example.todolist.dto.schedule.ScheduleRequestDto;
import com.example.todolist.dto.schedule.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.service.scheduleservice.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ScheduleController {
    ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules") // 일정 생성 요청 API
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody @Valid ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/schedules") // 일정 전체 조회 요청 API
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
        return new ResponseEntity<>(scheduleService.findAllSchedules(), HttpStatus.OK);
    }

    @GetMapping("/schedules/{id}") // 일정 단건 조회 요청 API
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    @PutMapping("/schedules/{id}") //일정 수정 요청 API
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto), HttpStatus.OK);

    }

    @DeleteMapping("/schedules/{id}") // 일정 삭제 요청 API
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pages") //요청 페이지별 조회 API
    public ResponseEntity<List<UserScheduleResponseDto>> findByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(scheduleService.findByPage(page, size), HttpStatus.OK);

    }

}
