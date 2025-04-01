package com.greenuniv.greenuniv.config;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.service.DefaultGenericService;
import com.greenuniv.greenuniv.service.GenericService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
  public ModelMapper modelMapper() {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true);

    return modelMapper;
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

  @Bean
  public GenericService<ArticleDTO, Integer> articleService(
      GenericMapper<ArticleDTO, Integer> mapper) {
    return new DefaultGenericService<>(mapper);
  }

  @Bean
  public GenericService<CommentDTO, Integer> commentService(
      GenericMapper<CommentDTO, Integer> mapper) {
    return new DefaultGenericService<>(mapper);
  }
}
