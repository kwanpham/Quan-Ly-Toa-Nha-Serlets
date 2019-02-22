package com.quanlytoanha.mapper;

import com.quanlytoanha.model.BuildingModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingMapper implements RowMapper<BuildingModel> {

    @Override
    public BuildingModel mapRow(ResultSet rs) {
        try {
            BuildingModel buildingModel = new BuildingModel();
            buildingModel.setBuildingId(rs.getLong("id"));
            buildingModel.setName(rs.getString("name"));
            buildingModel.setDistrictId(rs.getInt("districtId"));
            buildingModel.setWard(rs.getString("ward"));
            buildingModel.setStreet(rs.getString("street"));
            buildingModel.setStructure(rs.getString("structure"));
            buildingModel.setNumberOfBasement(rs.getInt("numberOfBasement"));
            buildingModel.setBuildingArea(rs.getDouble("buildingArea"));
            buildingModel.setDirection(rs.getString("direction"));
            buildingModel.setLevelBuilding(rs.getString("levelBuilding"));
            buildingModel.setRentArea(rs.getString("rentArea"));
            buildingModel.setAreaDescription(rs.getString("areaDescription"));
            buildingModel.setCostRent(rs.getDouble("costRent"));
            buildingModel.setCostDescription(rs.getString("costDescription"));
            buildingModel.setServiceCost(rs.getDouble("serviceCost"));
            buildingModel.setCarCost(rs.getDouble("carCost"));
            buildingModel.setMotorbikeCost(rs.getDouble("motorbikeCost"));
            buildingModel.setOvertimeCost(rs.getDouble("overtimeCost"));
            buildingModel.setElectricityCost(rs.getDouble("electricityCost"));
            buildingModel.setDeposit(rs.getDouble("deposit"));
            buildingModel.setPayment(rs.getDouble("payment"));
            buildingModel.setTimeContract(rs.getTimestamp("timeContract"));
            buildingModel.setTimeDecorator(rs.getTimestamp("timeDecorator"));
            buildingModel.setManagerName(rs.getString("managerName"));
            buildingModel.setMamagerPhone(rs.getString("mamagerPhone"));
            buildingModel.setCommission(rs.getDouble("commission"));
            buildingModel.setNote(rs.getString("note"));
            buildingModel.setLink(rs.getString("link"));
            buildingModel.setLocation(rs.getString("location"));
            buildingModel.setImageName(rs.getString("imageName"));
            buildingModel.setThumbnailBase64(rs.getString("thumbnailBase64"));
            buildingModel.setStatus(rs.getInt("status"));
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
