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
    long totalItems = pagination.limit();

    assertEquals(0, pagination.offset());
    assertEquals(2, pagination.endPage());
    assertEquals(11, totalItems);
  }

  @Test
  void testPagination_withItemsLimitEqualsToMaxItems() {
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(10);
    pagination.setItemsCount(100);

    assertEquals(90, pagination.offset());
    assertEquals(10, pagination.endPage());
    assertEquals(100, pagination.limit());
  }

  @Test
  void testPagination_withItemsLimitGreaterThanMaxItems() {
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(3);
    pagination.setItemsCount(3127);

    assertEquals(20, pagination.offset());
    assertEquals(100, pagination.limit());
    assertEquals(10, pagination.endPage());
  }

  @Test
  void testPagination_withArticleService() {
    long count = service.countBy("category", "qna");
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(1);
    pagination.setItemsCount(count);

    int limit = pagination.limit();
    int offset = pagination.offset();

    assertEquals(0, pagination.offset());
    assertEquals(3, pagination.limit());
    assertEquals(1, pagination.endPage());

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

    int limit = pagination.limit();
    int offset = pagination.offset();

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
