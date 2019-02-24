package com.quanlytoanha.dao;

import com.quanlytoanha.model.DistrictModel;

import java.util.List;


public interface IDistrictDAO extends GenericDAO<DistrictModel> {

    DistrictModel findOne(Long id);

    List<DistrictModel> findAll();


}
