package com.greenuniv.greenuniv.controller.management;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ManagementController {


    @GetMapping("/management/managementMain")
    public String main() {return "/management/managementMain";}

    @GetMapping("/management/department")
    public String department() {return "/management/depertment";}

    @GetMapping("/management/educationOperation")
    public String educationOperation() {return "/management/educationOperation";}

    @GetMapping("/management/lectureList")
    public String lectureList() {return "/management/lectureList";}

    @GetMapping("/management/lectureRegister")
    public String lectureRegister() {return "/management/lectureRegister";}

    @GetMapping("/management/lectureStatus")
    public String lectureStatus() {return "/management/lectureStatus";}



}
