package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.file.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper extends GenericMapper<FileDTO, Integer> {

}
