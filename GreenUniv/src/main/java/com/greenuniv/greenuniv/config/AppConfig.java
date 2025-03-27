package com.greenuniv.greenuniv.config;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.service.DefaultGenericService;
import com.greenuniv.greenuniv.service.GenericService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.greenuniv.greenuniv")
@ComponentScan(basePackages = "com.greenuniv.greenuniv.dao.mapper")
public class AppConfig {

  @Bean
  public GenericService<RegistryLectureDTO, String> registryLectureService(
      GenericMapper<RegistryLectureDTO, String> mapper) {
    return new DefaultGenericService<>(mapper);
  }

  @Bean
  public GenericService<StudentDTO, String> studentService(
      GenericMapper<StudentDTO, String> mapper) {
    return new DefaultGenericService<>(mapper);
  }

  @Bean
  public GenericService<LectureDTO, String> lectureService(
      GenericMapper<LectureDTO, String> mapper) {
    return new DefaultGenericService<>(mapper);
  }

  @Bean
  public GenericService<RegistryDTO, String> registryService(
      GenericMapper<RegistryDTO, String> mapper) {
    return new DefaultGenericService<>(mapper);
  }

  @Bean
  public GenericService<ProfessorDTO, String> professorService(
      GenericMapper<ProfessorDTO, String> mapper) {
    return new DefaultGenericService<>(mapper);
  }
}
