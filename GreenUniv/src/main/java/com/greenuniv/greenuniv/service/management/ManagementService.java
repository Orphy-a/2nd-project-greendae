package com.greenuniv.greenuniv.service.management;

import com.greenuniv.greenuniv.dao.mapper.ProfessorMapper;
import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.department.CollegeEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import com.greenuniv.greenuniv.repository.login.UserRepository;
import com.greenuniv.greenuniv.repository.management.CollegeRepository;
import com.greenuniv.greenuniv.repository.management.DepartmentRepository;
import com.greenuniv.greenuniv.repository.management.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ManagementService {

    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final ProfessorMapper professorMapper;

    private final ModelMapper modelMapper;

    /*
    // 학과 리스트 출력
    public List<DepartmentDTO> departmentFindAll(){

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        return departmentEntities.stream()
                .map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .collect(Collectors.toList());

    }
    
    // 학과 정보
    public DepartmentDTO FindByDepartment(int id){

        Optional<DepartmentEntity> optDepartment = departmentRepository.findById(id);

        return optDepartment.map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class)).orElse(null);

    }


    // 교수 정보
    public void FindByProfessor(){
        professorMapper.selectAll();
    }


    // 유저 정보
    public UserDTO FindByUser(String id){

    }


    // 교수 리스트 출력
    public List<UserDTO> professorFindAll(){

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());

    }

*/
}
