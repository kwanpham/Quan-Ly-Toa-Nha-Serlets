package com.quanlytoanha.dao;

import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;

import java.util.List;

public interface IBuildingDAO extends GenericDAO<BuildingModel> {

    Long save(BuildingModel buildingModel);

    void update(BuildingModel updateModel);

    void delete(long id);

    int getTotalItem();

    BuildingModel findOne(long id);

    List<BuildingModel> findAll(Pageble pageble);


}
