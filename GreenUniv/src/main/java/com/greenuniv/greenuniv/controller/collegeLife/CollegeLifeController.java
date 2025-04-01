package com.greenuniv.greenuniv.controller.collegeLife;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CollegeLifeController {

    @GetMapping("/collegeLife/club")
    public String club(){return "/collegeLife/club";}

    @GetMapping("/collegeLife/diet")
    public String diet(){return "/collegeLife/diet";}

    @GetMapping("/collegeLife/council")
    public String council(){return "/collegeLife/council";}

    @GetMapping("/collegeLife/gallery")
    public String gallery(){return "/collegeLife/gallery";}


}
