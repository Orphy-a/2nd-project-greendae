package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dto.BaseDTO;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * 작성자: id3ntity99(이현민)
 * 내용: Service 인터페이스.
 */

@Service
public interface GenericService<T extends BaseDTO, K> {

  void save(T dto);

  T findById(K id);

  List<T> findAll();

  List<T> findAllBy(String colName, String value);

  List<T> findAllBy(String colName, int value);

  List<T> findAllById(K id);

  List<T> findLimit(int offset, int limit);

  List<T> findByLimit(int offset, int limit, String colName, String value);

  void updateById(K id, T dto);

  void updateColumn(String colName, String value, K id);

  void delete(K id);

  long count();

  long countBy(String colName, String value);
}
