package com.greenuniv.greenuniv.controller.support;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SupportController {

    @GetMapping("/support/curriculum")
    public String curriculum() {return "/support/curriculum";}

    @GetMapping("/support/lectureRegister")
    public String lectureRegister() {return "/support/lectureRegister";}

    @GetMapping("/support/record")
    public String record() {return "/support/record";}

    @GetMapping("/support/registerHistory")
    public String registerHistory() {
        return "/support/registerHistory"; // 반환값은 뷰 이름
    }
    @GetMapping("/support/score")
    public String score() {return "/support/score";}


}
