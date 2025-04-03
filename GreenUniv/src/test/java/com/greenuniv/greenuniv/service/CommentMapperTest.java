package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentMapperTest {

  @Autowired
  private GenericMapper<CommentDTO, Integer> mapper;

  @Test
  void test() {
    List<CommentDTO> comments = mapper.selectAllBy("article_id", 7);
    Assertions.assertEquals(2, comments.size());
    comments.forEach(System.out::println);
  }
}
