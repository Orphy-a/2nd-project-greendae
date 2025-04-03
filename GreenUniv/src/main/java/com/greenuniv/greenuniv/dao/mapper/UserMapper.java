package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.user.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends GenericMapper<UserDTO, String> {

}
