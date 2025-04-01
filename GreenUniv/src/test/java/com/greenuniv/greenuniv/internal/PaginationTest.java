package com.greenuniv.greenuniv.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.service.GenericService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaginationTest {

  @Autowired
  private GenericService<ArticleDTO, Integer> service;

  @Test
  void testPagination_withItemsLimitLessThanMaxItems() {
    Pagination pagination = new Pagination();

    pagination.setCurrentPage(1);
    pagination.setItemsCount(11);
    long totalItems = pagination.itemLimit();

    assertEquals(0, pagination.itemOffset());
    assertEquals(2, pagination.getEndPage());
    assertEquals(11, totalItems);
  }

  @Test
  void testPagination_withItemsLimitEqualsToMaxItems() {
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(10);
    pagination.setItemsCount(100);

    assertEquals(90, pagination.itemOffset());
    assertEquals(10, pagination.getEndPage());
    assertEquals(100, pagination.itemLimit());
  }

  @Test
  void testPagination_withItemsLimitGreaterThanMaxItems() {
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(3);
    pagination.setItemsCount(3127);

    assertEquals(20, pagination.itemOffset());
    assertEquals(100, pagination.itemLimit());
    assertEquals(10, pagination.getEndPage());
  }

  @Test
  void testPagination_withArticleService() {
    long count = service.countBy("category", "qna");
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(1);
    pagination.setItemsCount(count);

    int limit = pagination.itemLimit();
    int offset = pagination.itemOffset();

    assertEquals(0, pagination.itemOffset());
    assertEquals(3, pagination.itemLimit());
    assertEquals(1, pagination.getEndPage());

    List<ArticleDTO> articles = service.findByLimit(offset, limit, "category", "qna");
    assertEquals(3, articles.size());
    articles.forEach(article -> {
      assertEquals("qna", article.getCategory());
    });
  }

  @Test
  void testPagination_calculateNewsAndColumns_withArticleService() {
    long newsCount = service.countBy("category", "news");
    long columnCount = service.countBy("category", "column");
    long totalCount = newsCount + columnCount;

    Pagination pagination = new Pagination();
    pagination.setCurrentPage(1);
    pagination.setItemsCount(totalCount);

    int limit = pagination.itemLimit();
    int offset = pagination.itemOffset();

    assertEquals(totalCount, limit);
    assertEquals(0, offset);

    List<ArticleDTO> news = service.findByLimit(offset, limit, "category", "news");
    List<ArticleDTO> columns = service.findByLimit(offset, limit, "category", "column");

    news.forEach(article -> {
      assertTrue(article.getCategory().equals("news") || article.getCategory().equals("column"));
    });

    columns.forEach(article -> {
      assertTrue(article.getCategory().equals("news") || article.getCategory().equals("column"));
    });
  }
}
