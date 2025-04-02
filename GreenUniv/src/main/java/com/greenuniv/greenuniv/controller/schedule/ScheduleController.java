package com.greenuniv.greenuniv.controller.schedule;

import com.greenuniv.greenuniv.dto.schedule.ScheduleDTO;
import com.greenuniv.greenuniv.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "*") // CORS 문제 해결
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

    @GetMapping("/update")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(scheduleDTO);
    }
    @PostMapping("/update")
    public ScheduleDTO updateSchedule(){
        return null;
    }

    @DeleteMapping("/delete")
    public ScheduleDTO deleteSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.deleteSchedule(scheduleDTO);
    }

    }

