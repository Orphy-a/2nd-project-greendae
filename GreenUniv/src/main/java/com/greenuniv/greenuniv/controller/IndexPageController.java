package com.greenuniv.greenuniv.controller;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexPageController {

  private final GenericMapper<ArticleDTO, Integer> articleMapper;

  @Value("${spring.application.name}")
  private String appName;

  @Value("${spring.application.version}")
  private String appVersion;

  @GetMapping(value = {"/", "/index"})
  public String index(Model model) {
    //TODO: 1. 학사안내 대신 채용정보 데이터 내보내기
    List<ArticleDTO> employments = articleMapper.selectByLimit(0, 5, "category", "employment");

    //TODO: 2. 뉴스및칼럼 데이터 내보내기
    List<ArticleDTO> news = articleMapper.selectByLimit(0, 5, "category", "news");

    //TODO: 2.공지사항 데이터 내보내기
    List<ArticleDTO> notices = articleMapper.selectByLimit(0, 5, "category", "notice");

    //TODO: 3.갤러리 데이터 내보내기

    model.addAttribute("employments", employments);
    model.addAttribute("news", news);
    model.addAttribute("notices", notices);

    // 버전 출력
    model.addAttribute("appName", appName);
    model.addAttribute("appVersion", appVersion);

    return "/index";
  }


}
