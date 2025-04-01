package com.greenuniv.greenuniv.controller.humanmanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HumanManagement {

    @GetMapping("/humanResourcesManagement/professorregister")
    public String professorRegister() {return "/humanResourcesManagement/professorregister";}

    @GetMapping("/humanResourcesManagement/professorList")
    public String professorList() {return "/humanResourcesManagement/professorList";}
}

