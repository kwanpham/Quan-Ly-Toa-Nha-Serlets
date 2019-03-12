package com.quanlytoanha.dao;

import com.quanlytoanha.model.RoleModel;
import com.quanlytoanha.model.UserModel;

import java.util.List;


public interface IRoleDAO extends GenericDAO<RoleModel> {

    RoleModel findOne(Long id);

    Long save(RoleModel RoleModel);

    void update(RoleModel roleModel);

    void delete(long id);

    List<RoleModel> findAll();

    int getTotalItem();


}
