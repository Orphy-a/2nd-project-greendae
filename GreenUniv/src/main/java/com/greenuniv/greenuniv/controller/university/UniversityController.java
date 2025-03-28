package com.greenuniv.greenuniv.controller.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UniversityController {

    @GetMapping("/university/humanities")
    public String humanities(){return "/university/humanities";}

    @GetMapping("/university/naturalScience")
    public String naturalScience(){return "/university/naturalScience";}

    @GetMapping("/university/engineering")
    public String engineering(){return "/university/engineering";}

    @GetMapping("/university/education")
    public String education(){return "/university/education";}

    @GetMapping("/university/graduate")
    public String graduate(){return "/university/graduate";}
}
