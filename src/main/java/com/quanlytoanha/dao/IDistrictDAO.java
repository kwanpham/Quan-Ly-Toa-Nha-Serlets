package com.quanlytoanha.dao;

import com.quanlytoanha.model.DistrictModel;

import java.util.List;


public interface IDistrictDAO extends GenericDAO<DistrictModel>  {

    DistrictModel findOne(Long id);
    List<DistrictModel> findByBuildingId(Long buildingId);
    Long save(DistrictModel DistrictModel);
    void update(DistrictModel DistrictModel);
    void delete(long id);
    List<DistrictModel> findAll();
    int getTotalItem();
}
