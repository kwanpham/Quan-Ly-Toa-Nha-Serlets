package com.quanlytoanha.dao;

import com.quanlytoanha.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {

    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
