package com.greenuniv.greenuniv.controller.department;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class DepartmentController {

    @GetMapping("/department/departmentList")
    public String list(){return "/department/departmentList";}

    @GetMapping("/department/departmentRegister")
    public String register(){return "/department/departmentRegister";}


}
