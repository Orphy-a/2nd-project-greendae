package com.greenuniv.greenuniv.service.management;

import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.department.CollegeEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import com.greenuniv.greenuniv.repository.login.UserRepository;
import com.greenuniv.greenuniv.repository.management.CollegeRepository;
import com.greenuniv.greenuniv.repository.management.DepartmentRepository;
import com.greenuniv.greenuniv.repository.management.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ManagementService {

    private final CollegeRepository collegeRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    private final ModelMapper modelMapper;


    // 학부 출력
    public List<CollegeDTO> collegeFindAll(){

        List<CollegeEntity> collegeEntities = collegeRepository.findAll();


        return collegeEntities.stream()
                .map(entity -> new CollegeDTO(entity.getName()))
                .collect(Collectors.toList());

    }

    // 학과 출력
    public List<DepartmentDTO> departmentFindAll(){

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        return departmentEntities.stream()
                .map(entity -> new DepartmentDTO(entity.getName()))
                .collect(Collectors.toList());

    }

    // 교수 출력
    public List<UserDTO> professorFindAll(){

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream()
                .map(entity -> new UserDTO(entity.getName()))
                .collect(Collectors.toList());

    }

    // 강의 등록
    public void lectureRegister(LectureDTO lectureDTO){

        LectureEntity lectureEntity = modelMapper.map(lectureDTO, LectureEntity.class);




    }




}
