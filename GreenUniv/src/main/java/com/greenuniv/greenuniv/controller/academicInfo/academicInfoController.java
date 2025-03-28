package com.greenuniv.greenuniv.controller.academicInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class academicInfoController {

    @GetMapping("/academicInformation/notice")
    public String academicNotice(){return "/academicInformation/notice";}

    @GetMapping("/academicInformation/schedule")
    public String schedule(){return "/academicInformation/schedule";}

    @GetMapping("/academicInformation/registration")
    public String registration(){return "/academicInformation/registration";}

    @GetMapping("/academicInformation/score")
    public String score(){return "/academicInformation/score";}

    @GetMapping("/academicInformation/graduation")
    public String graduation(){return "/academicInformation/graduation";}

    @GetMapping("/academicInformation/qna")
    public String academicQna(){return "/academicInformation/qna";}

}
