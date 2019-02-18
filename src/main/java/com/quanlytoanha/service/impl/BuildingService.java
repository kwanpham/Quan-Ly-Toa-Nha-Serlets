package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.IBuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class BuildingService implements IBuildingService {

    @Inject
    private IBuildingDAO buildingDAO;

    @Override
    public BuildingModel save(BuildingModel buildingModel) {
         buildingModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
         buildingModel.setCreatedBy("Admin");
         Long buildingId = buildingDAO.save(buildingModel);
         return buildingDAO.findOne(buildingId);
    }

    @Override
    public BuildingModel update(BuildingModel updateModel) {
        BuildingModel  oldBuilding = buildingDAO.findOne(updateModel.getBuildingId());
        updateModel.setCreatedDate(oldBuilding.getCreatedDate());
        updateModel.setCreatedBy(oldBuilding.getCreatedBy());
        updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateModel.setModifiedBy("admin");
        buildingDAO.update(updateModel);
        return buildingDAO.findOne(updateModel.getBuildingId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids) {

            buildingDAO.delete(id);
        }
    }

    @Override
    public int getTotalItem() {
        return buildingDAO.getTotalItem();
    }

    @Override
    public BuildingModel findOne(long id) {
        return buildingDAO.findOne(id);
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        return buildingDAO.findAll(pageble);
    }
}
