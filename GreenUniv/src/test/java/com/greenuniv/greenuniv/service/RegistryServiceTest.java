package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dto.registry.RegistryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistryServiceTest {

  @Autowired
  private GenericService<RegistryDTO, String> service;

  @Test
  @DisplayName("수강신청내역 조회")
  void testSelectAllRegistry_success() {
    RegistryDTO registry = service.findById("20250001");
    String foundStudentNumber = registry.getStudent().getStudentNumber();

    Assertions.assertEquals("20250001", foundStudentNumber);
  }
}
