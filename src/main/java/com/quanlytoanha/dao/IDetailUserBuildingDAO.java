package com.quanlytoanha.dao;

import com.quanlytoanha.model.DetailBuildingTypeModel;
import com.quanlytoanha.model.DetailUserBuildingModel;


public interface IDetailUserBuildingDAO extends GenericDAO<DetailUserBuildingModel> {

    long save(DetailUserBuildingModel model);
    void delete(DetailUserBuildingModel model);
}
