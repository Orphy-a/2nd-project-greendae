package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfessorMapper extends GenericMapper<ProfessorDTO, String> {

}
