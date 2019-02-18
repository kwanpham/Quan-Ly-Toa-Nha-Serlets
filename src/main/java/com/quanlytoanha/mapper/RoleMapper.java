package com.quanlytoanha.mapper;

import com.quanlytoanha.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet rs) {
        try {
            RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(rs.getLong("roleId"));
            roleModel.setName(rs.getString("name"));
            roleModel.setStatus(rs.getInt("status"));
            roleModel.setCreatedDate(rs.getTimestamp("createdDate"));
            roleModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            roleModel.setCreatedBy(rs.getString("createdBy"));
            roleModel.setModifiedBy(rs.getString("modifiedBy"));
            return roleModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
