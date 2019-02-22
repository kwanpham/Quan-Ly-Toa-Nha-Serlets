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
    private IDetailUserBuildingDAO detailUserBuildingDAO;
    private IDetailBuildingTypeDAO detailBuildingTypeDAO;
    private IBuildingTypeDAO buildingTypeDAO;
    private IDistrictDAO districtDAO;

    public BuildingService() {
        buildingDAO = new BuildingDAO();
        detailUserBuildingDAO = new DetailUserBuidingDAO();
        detailBuildingTypeDAO = new DetailBuildingTypeDAO();
        buildingTypeDAO = new BuildingTypeDAO();
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

    @Override
    public List<DistrictModel> findAllDistrict() {
        DistrictDAO districtDAO = new DistrictDAO();
        return districtDAO.findAll();
    }

    @Override
    public DistrictModel findByBuildingId(long id) {
        return districtDAO.findByBuildingId(id);
    }

    @Override
    public long save(DetailBuildingTypeModel model) {
        return detailBuildingTypeDAO.save(model);
    }

    @Override
    public List<BuildingTypeModel> findAllBuildingType() {
        return buildingTypeDAO.findAll();
    }

    @Override
    public long save(DetailUserBuildingModel model) {
        return detailUserBuildingDAO.save(model);
    }
}
