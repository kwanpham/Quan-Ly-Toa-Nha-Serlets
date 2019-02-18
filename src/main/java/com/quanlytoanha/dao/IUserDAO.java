package com.quanlytoanha.dao;


import com.quanlytoanha.model.UserModel;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel> {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    UserModel findOne(Long id);
    List<UserModel> findByRoleId(Long categoryId);
    Long save(UserModel userModel);
    void update(UserModel userModel);
    void delete(long id);
    List<UserModel> findAll();
    int getTotalItem();

}
