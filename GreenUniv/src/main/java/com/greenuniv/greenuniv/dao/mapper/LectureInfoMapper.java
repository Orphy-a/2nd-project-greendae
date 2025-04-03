package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.lecture.LectureInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureInfoMapper extends GenericMapper<LectureInfoDTO, String> {
    void insertLectureInfo(LectureInfoDTO lectureInfoDTO);
}
