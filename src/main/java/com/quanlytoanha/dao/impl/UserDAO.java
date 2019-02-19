package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IUserDAO;
import com.quanlytoanha.mapper.UserMapper;
import com.quanlytoanha.model.UserModel;

import java.util.List;


public class UserDAO extends AbsstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findOne(Long id) {
        String sql = "SELECT * FROM user WHERE userid = ?";
        List<UserModel> user = query(sql, new UserMapper(), id);
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    public List<UserModel> findByRoleId(Long roleId) {
        String sql = "SELECT * FROM news WHERE roleid = ?";
        return query(sql, new UserMapper(), roleId);
    }

    @Override
    public Long save(UserModel userModel) {
        String sql =  autoWriteInsertSQL("user");
        return insert(sql, userModel.getUsername() ,userModel.getPassword() ,userModel.getFullName() ,userModel.getStatus() ,
                userModel.getRoleId() ,userModel.getManagerId() ,userModel.getCreatedDate() ,userModel.getModifiedDate() ,
                userModel.getCreatedBy() ,userModel.getModifiedBy());

    }

    @Override
    public void update(UserModel userModel) {
        String sql = autoWriteUpdateSQL("user");


        update(sql, userModel.getUsername() ,userModel.getPassword() ,userModel.getFullName() ,userModel.getStatus() ,
                userModel.getRoleId() ,userModel.getManagerId() ,userModel.getCreatedDate() ,userModel.getModifiedDate() ,
                userModel.getCreatedBy() ,userModel.getModifiedBy() , userModel.getUserId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM user WHERE userid = ?";
        update(sql, id);
    }

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM user";
        return query(sql , new UserMapper() );
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM user";
        return count(sql);
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        String sql = "select * from user where username = ? , password = ? , status = ? ";
        return  query(sql , new UserMapper() , userName , password ,status).get(0);
    }

    @Override
    public List<UserModel> findByMangerId(long managerId) {
        String sql = "SELECT * FROM user where mangerId = ? " ;
        return query(sql , new UserMapper() , managerId);
    }
}
