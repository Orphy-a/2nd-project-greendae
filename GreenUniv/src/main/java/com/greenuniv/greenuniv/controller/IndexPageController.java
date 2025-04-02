package com.greenuniv.greenuniv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexPageController {


  @Value("${spring.application.name}")
  private String appName;

  @Value("${spring.application.version}")
  private String appVersion;

  @GetMapping(value = {"/", "/index"})
  public String index(Model model) {
    //TODO: 1.학사안내 데이터 내보내기
    //TODO: 2.공지사항 데이터 내보내기
    //TODO: 3.갤러리 데이터 내보내기
    
    // 버전 출력
    model.addAttribute("appName", appName);
    model.addAttribute("appVersion", appVersion);

    return "/index";
  }



}
