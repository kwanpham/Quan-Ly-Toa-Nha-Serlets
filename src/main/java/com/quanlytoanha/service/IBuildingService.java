package com.quanlytoanha.service;

import com.quanlytoanha.builder.BuildingSearcher;
import com.quanlytoanha.model.*;
import com.quanlytoanha.paging.Pageble;

import java.util.List;
import java.util.Map;

public interface IBuildingService {

    BuildingModel save(BuildingModel buildingModel);

    BuildingModel update(BuildingModel updateModel);

    void delete(long[] ids);

    Map<String , String> getBuildTypes();

    int getTotalItem();

    BuildingModel findOne(long id);

    List<BuildingModel> findAll(Pageble pageble);

    List<BuildingModel> findAll(BuildingSearcher builder , Pageble pageble);



}
