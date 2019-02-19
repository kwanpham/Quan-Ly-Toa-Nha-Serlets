package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IDistrictDAO;
import com.quanlytoanha.mapper.DistrictMapper;
import com.quanlytoanha.model.DistrictModel;


import java.util.List;


public class DistrictDAO extends AbsstractDAO<DistrictModel> implements IDistrictDAO {


    @Override
    public DistrictModel findOne(Long id) {
        String sql = "SELECT * FROM district WHERE districtid = ?";
        List<DistrictModel> district = query(sql, new DistrictMapper(), id);
        return district.isEmpty() ? null : district.get(0);
    }

    @Override
    public DistrictModel findByBuildingId(Long buildingId) {
        String sql = "SELECT * FROM district WHERE roleid = ?";
        return query(sql, new DistrictMapper(), buildingId).get(0);
    }

    @Override
    public Long save(DistrictModel districtModel) {
        String sql = autoWriteInsertSQL("district") ;
        return insert(sql , districtModel.getName() ,districtModel.getStatus() ,districtModel.getCreatedDate() ,
                districtModel.getModifiedDate() ,districtModel.getCreatedBy() ,districtModel.getModifiedBy()) ;
    }

    @Override
    public void update(DistrictModel districtModel) {
        String sql = autoWriteUpdateSQL("district") ;
        update(sql , districtModel.getName() ,districtModel.getStatus() ,districtModel.getCreatedDate() ,
                districtModel.getModifiedDate() ,districtModel.getCreatedBy() ,districtModel.getModifiedBy() , districtModel.getDistrictId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM district WHERE districtid = ?";
        update(sql, id);
    }

    @Override
    public List<DistrictModel> findAll() {
        String sql = "SELECT * FROM District";
        return query(sql , new DistrictMapper() );
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM District";
        return count(sql);
    }
}
