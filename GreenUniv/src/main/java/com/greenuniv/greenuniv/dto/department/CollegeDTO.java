package com.greenuniv.greenuniv.dto.department;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.entity.department.CollegeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDTO implements BaseDTO {

  private int id;
  private String name;
  private String engName;
  private String description;
  private ImageDTO image;

  // 학부 이름만 출력 생성자
  public CollegeDTO(String name) {
    this.name = name;
  }


  @Override
  public CollegeEntity toEntity() {
    return CollegeEntity.builder()
        .id(id)
        .name(name)
        .engName(engName)
        .description(description)
        .image(image.toEntity())
        .build();
  }
}
