package com.greenuniv.greenuniv.controller.management;

import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.service.management.ManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping("/management/managementMain")
    public String main() {return "/management/managementMain";}

    @GetMapping("/management/department")
    public String department() {return "/management/department";}

    @GetMapping("/management/educationOperation")
    public String educationOperation() {return "/management/educationOperation";}

    @GetMapping("/management/lectureList")
    public String lectureList() {return "/management/lectureList";}

    @GetMapping("/management/lectureRegister")
    public String lectureRegister(Model model) {

        // 학부
        List<CollegeDTO> collegeDTOS = managementService.collegeFindAll();
        model.addAttribute("collegeDTOS", collegeDTOS);

        // 학과
        List<DepartmentDTO> departmentDTOS = managementService.departmentFindAll();
        model.addAttribute("departmentDTOS", departmentDTOS);

        // 교수
        List<UserDTO> userDTOS = managementService.professorFindAll();
        model.addAttribute("userDTOS", userDTOS);


        return "/management/lectureRegister";
    }

    @PostMapping("/management/lectureRegister")
    public String lectureRegister(){




        return "redirect:/management/lectureList";
    }

    @GetMapping("/management/lectureStatus")
    public String lectureStatus() {return "/management/lectureStatus";}





}
