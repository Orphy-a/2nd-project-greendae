package com.greenuniv.greenuniv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceTest {

  @Autowired
  private GenericService<ArticleDTO, Integer> service;

  @Autowired
  private GenericService<CommentDTO, Integer> commentService;

  @Test
  @DisplayName("게시물 목록 조회")
  void testSelectAllArticles_success() {
    List<ArticleDTO> articles = service.findAll();
    articles.forEach((article) -> {
      System.out.println(article);
      assertTrue(article.getId() > 0);
      assertNotNull(article.getUser().getId());
      assertNotNull(article.getUser().getName());
      assertNotNull(article.getTitle());
      assertNotNull(article.getCategory());
      assertNotNull(article.getContent());
      assertTrue(article.getView() >= 0);
      assertNotNull(article.getRegisterDate());
    });
  }

  @Test
  void testSelectArticle_withItsAllComments_success() {
    ArticleDTO article = service.findById(7);
    List<CommentDTO> comments = commentService.findAllWith("article_id", article.getId());
    comments.forEach((comment) -> {
      assertTrue(comment.getId() > 0);
      assertNotNull(comment.getUser().getId());
      assertNotNull(article.getUser().getName());
      assertNull(comment.getArticle());
    });
  }

  @Test
  void test() {
    List<ArticleDTO> notices = service.findAllWith("category", "notice");
    notices.forEach((article) -> {
      assertEquals("notice", article.getCategory());
    });
  }
}
