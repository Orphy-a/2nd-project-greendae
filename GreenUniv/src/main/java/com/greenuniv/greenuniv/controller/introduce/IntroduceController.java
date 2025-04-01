package com.greenuniv.greenuniv.controller.introduce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IntroduceController {

    @GetMapping("/introduce/map")
    public String map(){return "/introduce/map";}

    @GetMapping("/introduce/greeting")
    public String greeting(){return "/introduce/greeting";}

    @GetMapping("/introduce/history")
    public String history(){return "/introduce/history";}

    @GetMapping("/introduce/ideology")
    public String ideology(){return "/introduce/ideology";}

    @GetMapping("/introduce/organization")
    public String organization(){return "/introduce/organization";}


}
