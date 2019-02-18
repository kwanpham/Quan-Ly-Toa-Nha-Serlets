package com.quanlytoanha.dao;

import com.quanlytoanha.model.BuildingTypeModel;
import com.quanlytoanha.model.UserModel;

import java.util.List;

/**
 * Created by MyPC on 18/02/2019.
 */
public interface IBuildingTypeDAO extends GenericDAO<BuildingTypeModel> {

    BuildingTypeModel findOne(Long id);
    Long save(BuildingTypeModel buildingTypeModel);
    void update(BuildingTypeModel buildingTypeModel);
    void delete(long id);
    List<BuildingTypeModel> findAll();
    int getTotalItem();
}
