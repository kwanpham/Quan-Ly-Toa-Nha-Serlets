package com.quanlytoanha.dao.impl;


import com.quanlytoanha.dao.IDetailBuildingTypeDAO;
import com.quanlytoanha.model.DetailBuildingTypeModel;


public class DetailBuildingTypeDAO extends AbsstractDAO<DetailBuildingTypeModel> implements IDetailBuildingTypeDAO {

    public long insert(DetailBuildingTypeModel detailBuildingTypeModel) {
        String sql = autoWriteInsertSQL("DetailBuildingType");
        return insert(sql , detailBuildingTypeModel.getBuildingId() ,detailBuildingTypeModel.getBuildingTypeId() ,
                detailBuildingTypeModel.getCreatedDate() , detailBuildingTypeModel.getModifiedDate() ,
                detailBuildingTypeModel.getCreatedBy() ,detailBuildingTypeModel.getModifiedBy());
    }

    public void delete(DetailBuildingTypeModel detailBuildingTypeModel) {
        String sql = "delete from detailbuildingtype where buildingId = ? and  buildingTypeId = ?";
        update(sql , detailBuildingTypeModel.getBuildingId() , detailBuildingTypeModel.getBuildingTypeId());

    }

}
