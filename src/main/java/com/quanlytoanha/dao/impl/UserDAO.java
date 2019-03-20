package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IUserDAO;

import com.quanlytoanha.model.UserModel;

import java.util.List;


public class UserDAO extends AbsstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findOne(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<UserModel> user = query(sql, UserModel.class, id);
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    public List<UserModel> findByRoleId(long roleId) {
        String sql = "SELECT * FROM user WHERE roleid = ?";
        return query(sql, UserModel.class, roleId);
    }

    @Override
    public Long save(UserModel userModel) {
        String sql =  autoWriteInsertSQL("user");
        return insert(sql, userModel);

    }

    @Override
    public void update(UserModel userModel) {
        String sql = autoWriteUpdateSQL("user");
        update(sql, userModel);
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        delete(sql, id);
    }

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM user";
        return query(sql , UserModel.class );
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM user";
        return count(sql);
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        String sql = "select * from user where username = ? , password = ? , status = ? ";
        return  query(sql , UserModel.class , userName , password ,status).get(0);
    }


}
