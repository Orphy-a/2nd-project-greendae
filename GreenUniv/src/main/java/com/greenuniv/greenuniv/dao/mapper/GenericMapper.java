package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.BaseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

/**
 * @param <T> BaseDTO를 상속하는 모든 DTO 클래스
 * @param <K> DTO에서 사용하는 Primary Key
 * @author id3ntity99(이현민)  Mybatis mapper. Strategy 패턴을 적용.
 */
@Mapper
@Primary
public interface GenericMapper<T extends BaseDTO, K> {

  void insert(T t);


  T selectById(K id);

  List<T> selectAll();

  List<T> selectAllWith(String colName, String value);

  List<T> selectAllWith(String colName, int value);

  List<T> selectAllById(K id);


  void updateById(K id, T t);

  void deleteById(K id);

  void updateColumn(String columnName, Object value, K id);
}
