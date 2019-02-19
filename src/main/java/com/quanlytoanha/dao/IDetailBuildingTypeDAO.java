package com.quanlytoanha.dao;

import com.quanlytoanha.model.DetailBuildingTypeModel;


public interface IDetailBuildingTypeDAO extends GenericDAO<DetailBuildingTypeModel> {

    long save(DetailBuildingTypeModel model);
    void delete(DetailBuildingTypeModel model);


}
