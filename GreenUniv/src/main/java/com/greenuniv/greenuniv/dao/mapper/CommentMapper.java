package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends GenericMapper<CommentDTO, Integer> {

}
