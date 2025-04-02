package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaDTO implements BaseDTO {

  private ArticleDTO question;
  private ArticleDTO answer;
  private boolean isPrivate;
  private String password;

  @Override
  public BaseEntity toEntity() {
    //TODO Impl this.
    return null;
  }
}
