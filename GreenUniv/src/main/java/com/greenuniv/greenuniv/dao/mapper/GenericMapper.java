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

  List<T> selectAllBy(String colName, String value);

  List<T> selectAllBy(String colName, int value);

  List<T> selectAllById(K id);

  List<T> selectLimit(int offset, int limit);

  List<T> selectByLimit(int offset, int limit, String colName, String value);

  List<T> selectWhereOr(int offset, int limit, String colName, String... value);

  void updateById(K id, T t);

  void updateColumn(String colName, String value, K id);

  void deleteById(K id);

  long count();

  long countBy(String colName, String value);
}
