package com.dao;

import com.quanlytoanha.dao.impl.BuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.PageRequest;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.impl.BuildingService;
import com.quanlytoanha.sort.Sorter;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.List;


public class TestDAO {

    @Test
    public void TestBuildingDAOSave(){
        BuildingDAO dao = new BuildingDAO();
        BuildingModel model = new BuildingModel();

        model.setName("Toa Nha 7200");
        model.setDistrictCode("quan_1");
        model.setCostRent(253000);
        model.setBuildingArea(34.4);
     //   model.setTableName("building");
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));

        long check = dao.save(model);
    }

    @Test
    public void TestBuildingDAOUpate(){
        BuildingDAO dao = new BuildingDAO();
        BuildingModel model = new BuildingModel();

        model.setId(23);
        model.setName("Toa Nha Tan binh");
        model.setDistrictCode("quan_1");
        model.setCostRent(253000);
      // model.setTableName("building");
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));


        dao.update(model);
    }

    @Test
    public void TestBuildingDAOFindOne() {
        BuildingDAO dao = new BuildingDAO();

        //BuildingModel model = dao.findOne(26);
    }

    @Test
    public void TestBuildingDAOFindAll() {
        BuildingDAO dao = new BuildingDAO();
        Pageble pageble = new PageRequest(1, 3 , new Sorter("name" , "asc"));

        List<BuildingModel> list = dao.findAll(pageble);
    }


}
