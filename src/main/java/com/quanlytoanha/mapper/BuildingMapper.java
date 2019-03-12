package com.quanlytoanha.mapper;

import com.quanlytoanha.model.BuildingModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingMapper implements RowMapper<BuildingModel> {

    @Override
    public BuildingModel mapRow(ResultSet rs) {
        try {
            BuildingModel buildingModel = new BuildingModel();
            buildingModel.setId(rs.getLong("id"));
            buildingModel.setName(rs.getString("name"));
            buildingModel.setDistrictCode(rs.getString("districtCode"));
            buildingModel.setWard(rs.getString("ward"));
            buildingModel.setStreet(rs.getString("street"));
            buildingModel.setStructure(rs.getString("structure"));
            buildingModel.setNumberOfBasement(rs.getInt("numberOfBasement"));
            buildingModel.setBuildingArea(rs.getDouble("buildingArea"));
            buildingModel.setDirection(rs.getString("direction"));
            buildingModel.setLevelBuilding(rs.getString("levelBuilding"));
            buildingModel.setCostRent(rs.getInt("costRent"));
            buildingModel.setCostDescription(rs.getString("costDescription"));
            buildingModel.setServiceCost(rs.getString("serviceCost"));
            buildingModel.setCarCost(rs.getString("carCost"));
            buildingModel.setMotorbikeCost(rs.getString("motorbikeCost"));
            buildingModel.setOvertimeCost(rs.getString("overtimeCost"));
            buildingModel.setElectricityCost(rs.getString("electricityCost"));
            buildingModel.setDeposit(rs.getString("deposit"));
            buildingModel.setPayment(rs.getString("payment"));
            buildingModel.setTimeContract(rs.getString("timeContract"));
            buildingModel.setTimeDecorator(rs.getString("timeDecorator"));
            buildingModel.setManagerName(rs.getString("managerName"));
            buildingModel.setManagerPhone(rs.getString("mamagerPhone"));
            buildingModel.setCommission(rs.getString("commission"));
            buildingModel.setNote(rs.getString("note"));
            buildingModel.setLink(rs.getString("link"));
            buildingModel.setLocation(rs.getString("location"));
            buildingModel.setImage(rs.getString("image"));
            buildingModel.setCreatedDate(rs.getTimestamp("createdDate"));
            buildingModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            buildingModel.setCreatedBy(rs.getString("createdBy"));
            buildingModel.setModifiedBy(rs.getString("modifiedBy"));

            return buildingModel;


        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }


    }
}
