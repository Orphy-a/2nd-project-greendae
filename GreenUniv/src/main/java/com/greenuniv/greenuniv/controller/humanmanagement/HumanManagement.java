package com.greenuniv.greenuniv.controller.humanmanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HumanManagement {

    @GetMapping("/humanResourcesManagement/professorRegister")
    public String professorRegister() {return "/humanResourcesManagement/professorRegister";}

    @GetMapping("/humanResourcesManagement/professorList")
    public String professorList() {return "/humanResourcesManagement/professorList";}

    @GetMapping("/humanResourcesManagement/studentList")
    public String studentList() {return "/humanResourcesManagement/studentList";}

    @GetMapping("/humanResourcesManagement/studentRegister")
    public String studentRegister() {return "/humanResourcesManagement/studentRegister";}

}

