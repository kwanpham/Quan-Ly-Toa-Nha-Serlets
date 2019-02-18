package com.dao;

import com.quanlytoanha.dao.impl.DetailBuildingTypeDAO;
import com.quanlytoanha.model.DetailBuildingTypeModel;
import org.testng.annotations.Test;

import java.sql.Timestamp;

/**
 * Created by MyPC on 18/02/2019.
 */
public class TestDAO {

    @Test
    public void DetailBuildingTypeDAOTest(){
        DetailBuildingTypeDAO detailBuildingTypeDAO = new DetailBuildingTypeDAO();
        DetailBuildingTypeModel detailBuildingTypeModel = new DetailBuildingTypeModel();
        detailBuildingTypeModel.setBuildingId(3);
        detailBuildingTypeModel.setBuildingTypeId(2);
        detailBuildingTypeModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        long check = detailBuildingTypeDAO.insert(detailBuildingTypeModel);
        System.out.println(check + "");

    }
}
