package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dto.schedule.ScheduleDTO;
import com.greenuniv.greenuniv.entity.schedule.ScheduleEntity;
import com.greenuniv.greenuniv.repository.login.ScheduleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDTO> getSchedulesForMonth(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return scheduleRepository.findByDateBetween(start, end)
                .stream()
                .map(ScheduleEntity::toDTO)
                .collect(Collectors.toList());
    }

    public ScheduleDTO addSchedule(ScheduleDTO scheduleDTO) {
        ScheduleEntity schedule = ScheduleEntity.builder()
                .title(scheduleDTO.getTitle())
                .date(scheduleDTO.getDate())
                .build();
        ScheduleEntity saved = scheduleRepository.save(schedule);
        return saved.toDTO();
    }

    public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO) {
        // 📌 기존 일정 찾기
        ScheduleEntity existingSchedule = scheduleRepository.findById(scheduleDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다: " + scheduleDTO.getId()));

        // 📌 값 업데이트
        existingSchedule = ScheduleEntity.builder()
                .id(existingSchedule.getId()) // 기존 ID 유지
                .title(scheduleDTO.getTitle())
                .date(scheduleDTO.getDate())
                .build();

        // 📌 저장 후 반환
        ScheduleEntity updatedSchedule = scheduleRepository.save(existingSchedule);
        return updatedSchedule.toDTO();
    }

    public ScheduleDTO deleteSchedule(ScheduleDTO scheduleDTO) {
        ScheduleEntity schedule = ScheduleEntity.builder()
                .title(scheduleDTO.getTitle())
                .date(scheduleDTO.getDate())
                .build();
        ScheduleEntity delete = scheduleRepository.save(schedule);
        return delete.toDTO();
    }

}