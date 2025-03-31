package com.greenuniv.greenuniv.controller.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {

  @GetMapping("") // == /article
  public String list(@RequestParam String category,
      @RequestParam(required = false, defaultValue = "1") int page,
      @RequestParam(required = false, defaultValue = "10") int offset, Model model) {

    String templatePath = String.format("/community/%s", category);
    log.info("Incoming request for /article?{}&{}&{}& has been detected", category, page, offset);
    log.info("Retrieving page for {}", templatePath);

    return templatePath;
  }
}
