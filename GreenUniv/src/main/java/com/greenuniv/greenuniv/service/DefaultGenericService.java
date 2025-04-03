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
  public void save(T dto) {
    mapper.insert(dto);
  }

  @Override
  public List<T> findAll() {
    return mapper.selectAll();
  }

  @Override
  public List<T> findAllBy(String colName, String value) {
    return mapper.selectAllBy(colName, value);
  }

  @Override
  public List<T> findAllBy(String colName, int value) {
    return mapper.selectAllBy(colName, value);
  }

  @Override
  public List<T> findAllById(K id) {
    return mapper.selectAllById(id);
  }

  @Override
  public List<T> findLimit(int offset, int limit) {
    return mapper.selectLimit(offset, limit);
  }

  @Override
  public List<T> findByLimit(int offset, int limit, String colName, String value) {
    return mapper.selectByLimit(offset, limit, colName, value);
  }

  @Override
  public void updateById(K id, T dto) {
    mapper.updateById(id, dto);
  }

  @Override
  public void updateColumn(String colName, String value, K id) {
    mapper.updateByIdWhere(id, colName, value);
  }

  @Override
  public T findById(K id) {
    return mapper.selectById(id);
  }

  @Override
  public void delete(K id) {
    mapper.deleteById(id);
  }

  @Override
  public long count() {
    return mapper.count();
  }

  @Override
  public long countBy(String colName, String value) {
    return mapper.countBy(colName, value);
  }
}
