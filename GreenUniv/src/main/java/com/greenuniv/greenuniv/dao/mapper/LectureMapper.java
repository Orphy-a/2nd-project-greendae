package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureMapper extends GenericMapper<LectureDTO, String> {

    void insertLecture(LectureDTO lectureDTO);
}
