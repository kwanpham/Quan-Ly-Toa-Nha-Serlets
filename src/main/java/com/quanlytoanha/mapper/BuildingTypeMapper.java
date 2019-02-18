package com.quanlytoanha.mapper;

import com.quanlytoanha.model.BuildingTypeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingTypeMapper implements RowMapper<BuildingTypeModel> {
    @Override
    public BuildingTypeModel mapRow(ResultSet rs) {

        try {
            BuildingTypeModel buildingTypeModel = new BuildingTypeModel();
            buildingTypeModel.setBuildingTypeId(rs.getLong("buildingTypeId"));
            buildingTypeModel.setName(rs.getString("name"));
            buildingTypeModel.setStatus(rs.getInt("status"));
            buildingTypeModel.setCreatedDate(rs.getTimestamp("createdDate"));
            buildingTypeModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            buildingTypeModel.setCreatedBy(rs.getString("createdBy"));
            buildingTypeModel.setModifiedBy(rs.getString("modifiedBy"));
            return buildingTypeModel;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
