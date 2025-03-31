package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfessorServiceTest {

  @Autowired
  GenericService<ProfessorDTO, String> service;

  @Test
  @DisplayName("교수 목록 조회")
  void testSelectAllProfessors_success() {
    List<ProfessorDTO> professors = service.findAll();
    Assertions.assertNotEquals(0, professors.size());
  }
}
