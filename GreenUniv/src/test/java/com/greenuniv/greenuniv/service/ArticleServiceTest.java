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

  private void assertArticle(ArticleDTO article) {
    assertTrue(article.getId() > 0);
    assertNotNull(article.getUser().getId());
    assertNotNull(article.getUser().getName());
    assertNotNull(article.getTitle());
    assertNotNull(article.getCategory());
    assertNotNull(article.getContent());
    assertTrue(article.getView() >= 0);
    assertNotNull(article.getRegisterDate());
  }

  @Test
  @DisplayName("😊 게시물 목록 조회")
  void testSelectAllArticles_success() {
    List<ArticleDTO> articles = service.findAll();
    articles.forEach(this::assertArticle);
  }

  @Test
  @DisplayName("😊 특정 게시물 + 댓글 전체 조회")
  void testSelectArticle_withItsAllComments_success() {
    ArticleDTO article = service.findById(7);
    List<CommentDTO> comments = commentService.findAllBy("article_id", article.getId());
    comments.forEach((comment) -> {
      assertTrue(comment.getId() > 0);
      assertNotNull(comment.getUser().getId());
      assertNotNull(article.getUser().getName());
      assertNull(comment.getArticle());
    });
  }

  @Test
  @DisplayName("😊 주어진 컬럼 및 값으로 조회")
  void testSelectArticle_withColumnNameAndValueGiven_success() {
    List<ArticleDTO> notices = service.findAllBy("category", "notice");
    notices.forEach((article) -> {
      assertEquals("notice", article.getCategory());
    });
  }

  @Test
  @DisplayName("😊 LIMIT - OFFSET 조회")
  void testSelectArticle_withOffsetAndLimit_success() {
    List<ArticleDTO> articles = service.findLimit(0, 2);
    assertEquals(2, articles.size());

    articles.forEach(this::assertArticle);
  }

  @Test
  @DisplayName("😊 SELECT - WHERE - LIMIT - OFFSET 조회")
  void testSelectArticle_withWhereAndLimit_success() {
    List<ArticleDTO> articles = service.findByLimit(0, 2, "category", "qna");
    assertEquals(2, articles.size());
    articles.forEach((article) -> {
      assertEquals("qna", article.getCategory());
    });
  }

  @Test
  void test() {
    ArticleDTO article = service.findById(7);
    System.out.println(article);
  }
}
