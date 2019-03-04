package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.*;
import com.quanlytoanha.dao.impl.*;
import com.quanlytoanha.enums.BuildingType;
import com.quanlytoanha.model.*;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class BuildingService implements IBuildingService {


    private IBuildingDAO buildingDAO;


    public BuildingService() {
        buildingDAO = new BuildingDAO();
    }

    @Override
    public BuildingModel save(BuildingModel buildingModel) {
        buildingModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        buildingModel.setCreatedBy("Admin");
        String type = String.join(",", buildingModel.getBuildingTypes());
        buildingModel.setType(type);
        Long buildingId = buildingDAO.save(buildingModel);
        return buildingDAO.findOne(buildingId);
    }

    @Override
    public BuildingModel update(BuildingModel updateModel) {
        BuildingModel oldBuilding = buildingDAO.findOne(updateModel.getId());
        updateModel.setCreatedDate(oldBuilding.getCreatedDate());
        updateModel.setCreatedBy(oldBuilding.getCreatedBy());
        updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateModel.setModifiedBy("admin");
        String type = String.join(",", updateModel.getBuildingTypes());
        updateModel.setType(type);
        buildingDAO.update(updateModel);
        return buildingDAO.findOne(updateModel.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            buildingDAO.delete(id);
        }
    }

    @Override
    public Map<String, String> getBuildTypes() {
        Map<String, String> results = new HashMap<>();
        // dùng stream put vào map
        Stream.of(BuildingType.values()).forEach(buildingType -> {
            results.put(buildingType.name(), buildingType.getName());
        });

        return results;
    }


    @Override
    public int getTotalItem() {
        return buildingDAO.getTotalItem();
    }

    @Override
    public BuildingModel findOne(long id) {
        BuildingModel model = buildingDAO.findOne(id);
        model.setBuildingTypes(model.getType().split(","));
        return model;
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        return buildingDAO.findAll(pageble);
    }

    @Override
    public List<DistrictModel> findAllDistrict() {
        DistrictDAO districtDAO = new DistrictDAO();
        return districtDAO.findAll();
    }


}
