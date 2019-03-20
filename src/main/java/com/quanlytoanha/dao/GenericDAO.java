package com.quanlytoanha.dao;


import com.quanlytoanha.model.AbstractModel;

import java.util.List;

public interface GenericDAO<T extends AbstractModel> {

    List<T> query(String sql, Class<T> tClass , Object... parameters);

    void update(String sql, T t);

    long insert(String sql, T t);

    int count(String sql, Object... parameters);
}
