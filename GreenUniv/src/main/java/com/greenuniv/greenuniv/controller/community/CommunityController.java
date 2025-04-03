package com.greenuniv.greenuniv.controller.community;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@Deprecated
public class CommunityController {

  @GetMapping("/community/notice")
  public String communityNotice() {
    return "/community/notice";
  }

  @GetMapping("/community/news")
  public String news() {
    return "/community/news";
  }

  @GetMapping("/community/job")
  public String job() {
    return "employment";
  }

  @GetMapping("/community/bulletin")
  public String bulletin() {
    return "/community/bulletin";
  }

  @GetMapping("/community/qna")
  public String communityQna() {
    return "/community/qna";
  }

  @GetMapping("/community/resources")
  public String resources() {
    return "/community/resources";
  }
}
