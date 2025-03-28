package com.greenuniv.greenuniv.dto.terms;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.terms.TermsEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TermsDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String title;
  private String content;

  @Override
  public TermsEntity toEntity() {
    return TermsEntity.builder()
        .id(id)
        .title(title)
        .content(content)
        .build();
  }
}
