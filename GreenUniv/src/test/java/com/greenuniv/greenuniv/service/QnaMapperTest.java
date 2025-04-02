package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.article.QnaDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {

  @Autowired
  private GenericMapper<QnaDTO, Integer> mapper;

  @Test
  void test() {
    List<QnaDTO> articles = mapper.selectLimit(0, 5);
    System.out.println(articles.size());
    articles.forEach(System.out::println);
  }
}
