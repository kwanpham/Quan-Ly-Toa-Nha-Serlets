package com.quanlytoanha.mapper;

import com.quanlytoanha.model.DetailBuildingTypeModel;
import com.quanlytoanha.model.DetailUserBuildingModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailUserBuildingMapper implements RowMapper<DetailUserBuildingModel> {
    @Override
    public DetailUserBuildingModel mapRow(ResultSet rs) {
        try {
            DetailUserBuildingModel detailUserBuildingModel = new DetailUserBuildingModel();
            detailUserBuildingModel.setUserId(rs.getLong("userId"));
            detailUserBuildingModel.setBuildingId(rs.getLong("buildingId"));
            detailUserBuildingModel.setCreatedDate(rs.getTimestamp("createdDate"));
            detailUserBuildingModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            detailUserBuildingModel.setCreatedBy(rs.getString("createdBy"));
            detailUserBuildingModel.setModifiedBy(rs.getString("modifiedBy"));
            return detailUserBuildingModel;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
