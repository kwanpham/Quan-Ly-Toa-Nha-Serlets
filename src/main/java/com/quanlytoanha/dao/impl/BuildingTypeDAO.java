package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IBuildingTypeDAO;
import com.quanlytoanha.mapper.BuildingTypeMapper;
import com.quanlytoanha.mapper.UserMapper;
import com.quanlytoanha.model.BuildingTypeModel;
import com.quanlytoanha.model.UserModel;

import java.util.List;


public class BuildingTypeDAO extends AbsstractDAO<BuildingTypeModel> implements IBuildingTypeDAO {
    @Override
    public BuildingTypeModel findOne(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<BuildingTypeModel> buildingTypeModel = query(sql, new BuildingTypeMapper(), id);
        return buildingTypeModel.isEmpty() ? null : buildingTypeModel.get(0);
    }


    @Override
    public Long save(BuildingTypeModel buildingTypeModel) {
        String sql = autoWriteInsertSQL("buildingtype");
        return insert(sql , buildingTypeModel.getName() ,buildingTypeModel.getStatus() ,buildingTypeModel.getCreatedDate() ,
                buildingTypeModel.getModifiedDate() ,buildingTypeModel.getCreatedBy() ,buildingTypeModel.getModifiedBy());
    }

    @Override
    public void update(BuildingTypeModel buildingTypeModel) {
        String sql = autoWriteUpdateSQL("buildingtype");
        update(sql , buildingTypeModel.getName() ,buildingTypeModel.getStatus() ,buildingTypeModel.getCreatedDate() ,
                buildingTypeModel.getModifiedDate() ,buildingTypeModel.getCreatedBy() ,buildingTypeModel.getModifiedBy() , buildingTypeModel.getBuildingTypeId());
    }

    @Override
    public void delete(long id) {
        String sql = "delete from buildingtype where buildingtypeid = ?";
        update(sql , id);
    }

    @Override
    public List<BuildingTypeModel> findAll() {
        String sql = "select *from buildingtype";
        return query(sql , new BuildingTypeMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from buildingtype";
        return count(sql);
    }
}
