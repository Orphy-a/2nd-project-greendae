package com.greenuniv.greenuniv.dto.schedule;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.schedule.ScheduleEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private LocalDate date;

  @Override
  public ScheduleEntity toEntity() {
    return ScheduleEntity.builder()
        .id(id)
        .title(title)
        .date(date)
        .build();
  }
}
