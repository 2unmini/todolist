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
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto),HttpStatus.CREATED);
    }

    @GetMapping("/schedules") // 일정 전체 조회 요청 API
    public ResponseEntity<List<ScheduleResponseDto>>findAllSchedules() {
        return new ResponseEntity<>(scheduleService.findAllSchedules(),HttpStatus.OK);
    }

    @GetMapping("/schedules/{id}") // 일정 단건 조회 요청 API
    public ResponseEntity<Optional<Schedule>> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id),HttpStatus.OK);
    }

    @PutMapping("/schedules/{id}") //일정 수정 요청 API
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto), HttpStatus.OK);

    }

    @DeleteMapping("/schedules/{id}") // 일정 삭제 요청 API
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.deleteSchedule(id, requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<UserScheduleResponseDto>> findByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(scheduleService.findByPage(page,size),HttpStatus.OK);

    }

}
