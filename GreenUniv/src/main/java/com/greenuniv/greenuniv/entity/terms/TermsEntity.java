package com.greenuniv.greenuniv.entity.terms;

import com.greenuniv.greenuniv.dto.terms.TermsDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "term")
@AllArgsConstructor
@NoArgsConstructor
public class TermsEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Override
  public TermsDTO toDTO() {
    return TermsDTO.builder()
        .id(id)
        .title(title)
        .content(content)
        .build();
  }
}
