package com.greenuniv.greenuniv.controller.enterInformation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class EnterInformation {


    @GetMapping("/EnterInformation/advice")
    public String advice(){return "/EnterInformation/advice";}
}
