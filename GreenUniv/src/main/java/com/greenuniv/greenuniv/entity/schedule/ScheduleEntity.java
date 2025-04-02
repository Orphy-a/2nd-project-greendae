package com.greenuniv.greenuniv.entity.schedule;

import com.greenuniv.greenuniv.dto.schedule.ScheduleDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "date")
  private LocalDate date;

  @Override
  public ScheduleDTO toDTO() {
    return ScheduleDTO.builder()
        .id(id)
        .title(title)
        .date(date)
        .build();
  }
}
