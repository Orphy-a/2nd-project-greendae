package com.greenuniv.greenuniv.service.management;

import com.greenuniv.greenuniv.dao.mapper.LectureInfoMapper;
import com.greenuniv.greenuniv.dao.mapper.LectureMapper;
import com.greenuniv.greenuniv.dao.mapper.RegistryLectureMapper;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureInfoDTO;
import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import com.greenuniv.greenuniv.repository.login.UserRepository;
import com.greenuniv.greenuniv.repository.management.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LectureRegisterService {

    private final LectureMapper lectureMapper;
    private final LectureInfoMapper lectureInfoMapper;
    private final RegistryLectureMapper registryLectureMapper;

    @Transactional
    public void registerLecture(LectureInfoDTO lectureInfoDTO, int maxRegistered) {

        // lecture_info
        lectureInfoMapper.insertLectureInfo(lectureInfoDTO);

        //
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.setLectureInfo(lectureInfoDTO);
        lectureMapper.insertLecture(lectureDTO);


        //
        RegistryLectureDTO registrylectureDTO = new RegistryLectureDTO();
        registrylectureDTO.setLecture(lectureDTO);
        registrylectureDTO.setMaxRegistered(maxRegistered);
        registryLectureMapper.insertRegistryLecture(registrylectureDTO);


    }

}
