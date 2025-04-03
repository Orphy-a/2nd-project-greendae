package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.article.ArticleEntity;
import java.time.LocalDate;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO implements BaseDTO {

  public static final String CATEGORY_NOTICE = "notice";
  public static final String CATEGORY_NEWS = "news";
  public static final String CATEGORY_COLUMN = "column";
  public static final String CATEGORY_EMPLOYMENT = "employment";
  public static final String CATEGORY_BULLETIN = "bulletin";
  public static final String CATEGORY_QNA = "qna";
  public static final String CATEGORY_GALLERY = "gallery";
  public static final String[] CATEGORIES = {CATEGORY_NOTICE, CATEGORY_NEWS, CATEGORY_COLUMN,
      CATEGORY_EMPLOYMENT, CATEGORY_BULLETIN, CATEGORY_QNA, CATEGORY_GALLERY};

  public static final String STATUS_OPEN = "open";
  public static final String STATUS_CLOSED = "close";
  public static final String[] STATUS = {STATUS_OPEN, STATUS_CLOSED};

  private int id;
  private UserDTO user;
  private String title;
  private String category;
  private String status;
  private String content;
  private int view;
  private LocalDate registerDate;

  @Override
  public ArticleEntity toEntity() {
    return ArticleEntity.builder()
        .id(id)
        .user(user.toEntity())
        .title(title)
        .category(category)
        .status(status)
        .content(content)
        .view(view)
        .registerDate(registerDate)
        .build();
  }

  public static class ArticleDTOBuilder {

    public ArticleDTO build() throws IllegalArgumentException {
      if (category != null && status != null) {
        boolean isCategoryLegal = Arrays.asList(CATEGORIES).contains(category);
        boolean isStatusLegal = Arrays.asList(STATUS).contains(status);

        if (!isCategoryLegal) {
          String message = String.format("유효하지 않은 카테고리([%s]): %s", Arrays.toString(CATEGORIES), category);
          throw new IllegalArgumentException(message);
        } else if (!isStatusLegal) {
          String message = String.format("유효하지 않은 게시물 상태([%s]): %s", Arrays.toString(STATUS), status);
          throw new IllegalArgumentException(message);
        }
      }
      return new ArticleDTO(id, user, title, category, status, content, view, registerDate);
    }
  }
}
