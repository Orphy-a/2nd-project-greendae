package com.greenuniv.greenuniv.dto.department;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private CollegeDTO college;
  private Year estabhlishedYear;
  private String name;
  private String englishName;
  private String contact;
  private String office;
  
  // 학과 이름만 출력 생성자
  public DepartmentDTO(String name) {
    this.name = name;
  }

    @Override
  public DepartmentEntity toEntity() {
    return DepartmentEntity.builder()
        .id(id)
        .college(college.toEntity())
        .establishedYear(estabhlishedYear)
        .name(name)
        .englishName(englishName)
        .contact(contact)
        .office(office)
        .build();
  }
}
