package com.quanlytoanha.dao;

import com.quanlytoanha.mapper.RowMapper;
import com.quanlytoanha.model.AbstractModel;

import java.util.List;

public interface GenericDAO<T> {

    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    <T extends AbstractModel> void update (String sql, T t);
    <T extends AbstractModel> long insert (String sql, T t);
    int count(String sql, Object... parameters);
}
