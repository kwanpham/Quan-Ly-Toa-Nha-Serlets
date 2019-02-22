package com.dao;

import com.quanlytoanha.dao.IDistrictDAO;
import com.quanlytoanha.dao.impl.DetailBuildingTypeDAO;
import com.quanlytoanha.dao.impl.DistrictDAO;
import com.quanlytoanha.model.DetailBuildingTypeModel;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.impl.BuildingService;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.sql.Timestamp;


public class TestDAO {

    @Test
    public void DetailBuildingTypeDAOTest(){
        DetailBuildingTypeDAO detailBuildingTypeDAO = new DetailBuildingTypeDAO();
        DetailBuildingTypeModel detailBuildingTypeModel = new DetailBuildingTypeModel();
        detailBuildingTypeModel.setBuildingId(3);
        detailBuildingTypeModel.setBuildingTypeId(2);
        detailBuildingTypeModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        long check = detailBuildingTypeDAO.save(detailBuildingTypeModel);
        System.out.println(check + "");

    }

//    @Inject
//    IBuildingService buildingService;

    @Test
    public void Select(){

        IBuildingService buildingService = new BuildingService();
        buildingService.findAllDistrict();
        buildingService.findAllBuildingType();

//        IDistrictDAO districtDAO = new DistrictDAO();
//        districtDAO.findAll();
    }
}
