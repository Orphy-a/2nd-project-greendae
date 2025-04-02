package com.greenuniv.greenuniv.repository.login;

import com.greenuniv.greenuniv.entity.schedule.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
    List<ScheduleEntity> findByDateBetween(LocalDate start, LocalDate end);
}
