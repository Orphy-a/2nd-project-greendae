package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.BaseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultGenericService<T extends BaseDTO, K> implements GenericService<T, K> {

  private GenericMapper<T, K> mapper;

  @Override
  public void insert(T dto) {

  }

  @Override
  public List<T> findAll() {
    return mapper.selectAll();
  }

  @Override
  public List<T> findAllWith(String colName, String value) {
    return mapper.selectAllWith(colName, value);
  }

  @Override
  public List<T> findAllWith(String colName, int value) {
    return mapper.selectAllWith(colName, value);
  }

  @Override
  public T findById(K id) {
    return mapper.selectById(id);
  }

  @Override
  public void updateById(T dto) {

  }

  @Override
  public void delete(K id) {

  }
}
