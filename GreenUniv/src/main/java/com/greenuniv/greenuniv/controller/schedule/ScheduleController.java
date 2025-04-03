package com.greenuniv.greenuniv.controller.schedule;

import com.greenuniv.greenuniv.dto.schedule.ScheduleDTO;
import com.greenuniv.greenuniv.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{year}/{month}")
    public List<ScheduleDTO> getSchedules(@PathVariable int year, @PathVariable int month) {
        return scheduleService.getSchedulesForMonth(year, month);
    }

    @PostMapping("/add")
    public ScheduleDTO addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.addSchedule(scheduleDTO);

    }

    @PutMapping("/update")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(scheduleDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int id) {

            scheduleService.deleteSchedule(id);
            return ResponseEntity.ok("일정을 삭제 했습니다");

    }
}

