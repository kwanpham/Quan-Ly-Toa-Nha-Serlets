package com.quanlytoanha.mapper;

import com.quanlytoanha.model.DistrictModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictMapper implements RowMapper<DistrictModel> {
    @Override
    public DistrictModel mapRow(ResultSet rs) {
        try {
            DistrictModel districtModel = new DistrictModel();
            districtModel.setId(rs.getLong("id"));
            districtModel.setName(rs.getString("name"));
            districtModel.setCode(rs.getString("code"));
            districtModel.setCreatedDate(rs.getTimestamp("createdDate"));
            districtModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            districtModel.setCreatedBy(rs.getString("createdBy"));
            districtModel.setModifiedBy(rs.getString("modifiedBy"));
            return districtModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
