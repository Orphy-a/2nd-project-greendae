package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends GenericMapper<ArticleDTO, Integer> {

}
