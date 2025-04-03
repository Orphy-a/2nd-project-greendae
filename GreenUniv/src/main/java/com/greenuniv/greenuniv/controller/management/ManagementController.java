package com.greenuniv.greenuniv.controller.management;

import com.greenuniv.greenuniv.dao.mapper.ProfessorMapper;
import com.greenuniv.greenuniv.dao.mapper.RegistryLectureMapper;
import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureInfoDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.service.GenericService;
import com.greenuniv.greenuniv.service.login.UserService;
import com.greenuniv.greenuniv.service.management.LectureRegisterService;
import com.greenuniv.greenuniv.service.management.ManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementService managementService;
    private final LectureRegisterService lectureRegisterService;


    @GetMapping("/management/managementMain")
    public String main() {return "/management/managementMain";}

    @GetMapping("/management/department")
    public String department() {return "/management/department";}

    @GetMapping("/management/educationOperation")
    public String educationOperation() {return "/management/educationOperation";}

    @GetMapping("/management/lectureList")
    public String lectureList() {return "/management/lectureList";}


//    @GetMapping("/management/lectureRegister")
//    public String lectureRegister(Model model) {
//
//        // 학과
//        List<DepartmentDTO> departmentDTOS = managementService.departmentFindAll();
//        model.addAttribute("departmentDTOS", departmentDTOS);
//
//        // 교수
//        List<UserDTO> userDTOS = managementService.professorFindAll();
//        model.addAttribute("userDTOS", userDTOS);
//
//
//        return "/management/lectureRegister";
//    }
//
//
//    @PostMapping("/management/lectureRegister")
//    public String lectureRegister(@RequestParam String id,
//                                  @RequestParam int department,
//                                  @RequestParam String professor,
//                                  @RequestParam String name,
//                                  @RequestParam int credit,
//                                  @RequestParam int semester,
//                                  @RequestParam String description,
//                                  @RequestParam String classification,
//                                  @RequestParam String textbook,
//                                  @RequestParam String classroom,
//                                  @RequestParam String evaluation_methods,
//                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_date,
//                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end_date,
//                                  @RequestParam int max_registered){
//
//
//
//        // 학과 및 교수 정보 설정
//        DepartmentDTO departmentDTO = managementService.FindByDepartment(department);
//
//
//
//
//
//
//
//
//
//        // LectureInfo DTO 생성
//        LectureInfoDTO lectureInfo = LectureInfoDTO.builder()
//                .id(id)
//                .department(departmentDTO)
//                .professor(professorDTO)
//                .name(name)
//                .credit(credit)
//                .semester(semester)
//                .description(description)
//                .textbook(textbook)
//                .classification(classification)
//                .classroom(classroom)
//                .startDate(start_date)
//                .endDate(end_date)
//                .evaluationMethods(evaluation_methods)
//                .build();
//
//        log.info(lectureInfo.toString());
//
//        // service 호출
//        lectureRegisterService.registerLecture(lectureInfo, max_registered);
//
//
//
//        return "redirect:/management/lectureList";
//    }


    @GetMapping("/management/lectureStatus")
    public String lectureStatus() {return "/management/lectureStatus";}





}
