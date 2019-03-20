package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IDistrictDAO;
import com.quanlytoanha.model.DistrictModel;


import java.util.List;


public class DistrictDAO extends AbsstractDAO<DistrictModel> implements IDistrictDAO {


    @Override
    public DistrictModel findOne(Long id) {
        String sql = "SELECT * FROM district WHERE districtid = ?";
        List<DistrictModel> district = query(sql, DistrictModel.class, id);
        return district.isEmpty() ? null : district.get(0);
    }


    @Override
    public List<DistrictModel> findAll() {
        String sql = "SELECT * FROM District";
        return query(sql , DistrictModel.class );
    }


}
