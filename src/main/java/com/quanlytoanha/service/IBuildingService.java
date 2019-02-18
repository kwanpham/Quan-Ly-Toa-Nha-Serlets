package com.quanlytoanha.service;

import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;

import java.util.List;

public interface IBuildingService {
    BuildingModel save(BuildingModel buildingModel);
    BuildingModel update(BuildingModel updateModel);
    void delete(long[] ids);
    int getTotalItem();
    BuildingModel findOne(long id);
    List<BuildingModel> findAll(Pageble pageble);
}
