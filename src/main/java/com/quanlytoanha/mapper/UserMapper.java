package com.quanlytoanha.mapper;

import com.quanlytoanha.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs) {
        try {
            UserModel userModel = new UserModel();
            userModel.setUserId(rs.getLong("userId"));
            userModel.setUsername(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setFullName(rs.getString("fullName"));
            userModel.setStatus(rs.getInt("status"));
            userModel.setRoleId(rs.getLong("roleId"));
            userModel.setManagerId(rs.getLong("managerId"));
            userModel.setCreatedDate(rs.getTimestamp("createdDate"));
            userModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            userModel.setCreatedBy(rs.getString("createdBy"));
            userModel.setModifiedBy(rs.getString("modifiedBy"));
            return null;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
