package com.dao;

import com.quanlytoanha.dao.impl.BuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.impl.BuildingService;
import org.testng.annotations.Test;

import java.sql.Timestamp;


public class TestDAO {

    @Test
    public void TestBuildingDAOSave(){
        BuildingDAO dao = new BuildingDAO();
        BuildingModel model = new BuildingModel();

        model.setName("Toa Nha 5");
        model.setDistrictCode("quan_1");
        model.setCostRent(253000);
        model.setTableName("building");
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        long check = dao.save(model);
    }

    @Test
    public void TestBuildingDAOUpate(){
        BuildingDAO dao = new BuildingDAO();
        BuildingModel model = new BuildingModel();

        model.setId(3);
        model.setName("Toa Nha Tan binh");
        model.setDistrictCode("quan_1");
        model.setCostRent(253000);
        model.setTableName("building");
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        dao.update(model);
    }


}
