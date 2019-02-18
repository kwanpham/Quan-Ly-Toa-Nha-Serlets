package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IDetailUserBuildingDAO;
import com.quanlytoanha.model.DetailUserBuildingModel;


public class DetailUserBuidingDAO extends AbsstractDAO<DetailUserBuildingModel> implements IDetailUserBuildingDAO {

    public long insert(DetailUserBuildingModel detailUserBuildingModel) {
        String sql = autoWriteInsertSQL("DetailUserBuilding");
        return insert(sql , detailUserBuildingModel.getUserId() , detailUserBuildingModel.getBuildingId() ,detailUserBuildingModel.getCreatedDate() ,
                detailUserBuildingModel.getModifiedDate() ,detailUserBuildingModel.getCreatedBy() ,detailUserBuildingModel.getModifiedBy());
    }

    public void delete(DetailUserBuildingModel model) {
        String sql = "delete from DetailUserBuildingModel where buildingId = ? and  userId = ?";
        update(sql , model.getBuildingId() , model.getUserId());

    }
}
