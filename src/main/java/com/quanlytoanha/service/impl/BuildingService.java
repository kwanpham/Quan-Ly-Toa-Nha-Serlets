package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.*;
import com.quanlytoanha.dao.impl.*;
import com.quanlytoanha.model.*;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;


public class BuildingService implements IBuildingService {


    private IBuildingDAO buildingDAO;

    private IDistrictDAO districtDAO;

    public BuildingService() {
        buildingDAO = new BuildingDAO();

        districtDAO = new DistrictDAO();
    }

    @Override
    public BuildingModel save(BuildingModel buildingModel) {
         buildingModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
         buildingModel.setCreatedBy("Admin");
         Long buildingId = buildingDAO.save(buildingModel);
         return buildingDAO.findOne(buildingId);
    }

    @Override
    public BuildingModel update(BuildingModel updateModel) {
        BuildingModel  oldBuilding = buildingDAO.findOne(updateModel.getId());
        updateModel.setCreatedDate(oldBuilding.getCreatedDate());
        updateModel.setCreatedBy(oldBuilding.getCreatedBy());
        updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateModel.setModifiedBy("admin");
        buildingDAO.update(updateModel);
        return buildingDAO.findOne(updateModel.getId());
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

    @Override
    public List<DistrictModel> findAllDistrict() {
        DistrictDAO districtDAO = new DistrictDAO();
        return districtDAO.findAll();
    }

    @Override
    public DistrictModel findByBuildingId(long id) {
        return null;
    }


}
