package com.quanlytoanha.mapper;

import com.quanlytoanha.model.DetailBuildingTypeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailBuildingTypeMapper implements RowMapper<DetailBuildingTypeModel> {
    @Override
    public DetailBuildingTypeModel mapRow(ResultSet rs) {

        try {
            DetailBuildingTypeModel detailBuildingTypeModel = new DetailBuildingTypeModel();
            detailBuildingTypeModel.setBuildingId(rs.getLong("buildingId"));
            detailBuildingTypeModel.setBuildingTypeId(rs.getLong("buildingTypeId"));
            detailBuildingTypeModel.setCreatedDate(rs.getTimestamp("createdDate"));
            detailBuildingTypeModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            detailBuildingTypeModel.setCreatedBy(rs.getString("createdBy"));
            detailBuildingTypeModel.setModifiedBy(rs.getString("modifiedBy"));
            return detailBuildingTypeModel;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
