package com.greenuniv.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

  @GetMapping(value = {"/", "/index"})
  public String index(Model model) {
    //TODO: 1.학사안내 데이터 내보내기
    //TODO: 2.공지사항 데이터 내보내기
    //TODO: 3.갤러리 데이터 내보내기
    return "/index";
  }

}
