package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegistryLectureMapper extends
    GenericMapper<RegistryLectureDTO, String> {
    void insertRegistryLecture(RegistryLectureDTO registryLectureDTO);
}
