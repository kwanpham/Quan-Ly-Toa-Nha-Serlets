package com.quanlytoanha.mapper;

import com.quanlytoanha.model.DistrictModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictMapper implements RowMapper<DistrictModel> {
    @Override
    public DistrictModel mapRow(ResultSet rs) {
        try {
            DistrictModel districtModel = new DistrictModel();
            districtModel.setDistrictId(rs.getLong("districtId"));
            districtModel.setName(rs.getString("name"));
            districtModel.setStatus(rs.getInt("status"));
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
