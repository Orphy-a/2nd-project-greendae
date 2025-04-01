package com.greenuniv.greenuniv.controller.enterInformation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EnterInformationController {

    @GetMapping("/enterInformation/advice")
    public String advice(){return "/enterInformation/advice";}

    @GetMapping("/enterInformation/regular")
    public String regular(){return "/enterInformation/regular";}

    @GetMapping("/enterInformation/jungsi")
    public String jungsi(){return "/enterInformation/jungsi";}

    @GetMapping("/enterInformation/counsel")
    public String counsel(){return "/enterInformation/counsel";}

    @GetMapping("/enterInformation/uvintro")
    public String uvintro(){return "/enterInformation/uvintro";}

}
