package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IRentAreaDAO;
import com.quanlytoanha.model.AbstractModel;
import com.quanlytoanha.model.RentAreaModel;

import java.util.List;

/**
 * Created by K.Wan on 07/03/2019.
 */
public class RentAreaDAO extends AbsstractDAO<RentAreaModel> implements IRentAreaDAO {
    @Override
    public Long save(RentAreaModel model) {
        String sql = autoWriteInsertSQL(RentAreaModel.tableName);
        return insert(sql,model);
    }

    @Override
    public void update(RentAreaModel model) {
        String sql = autoWriteUpdateSQL(RentAreaModel.tableName);
        update(sql , model);
    }

    @Override
    public void delete(long id) {
        String sql = "delete from rentarea whrere id = ?";
        delete(sql,id);

    }

    @Override
    public List<RentAreaModel> findByBuildingId(long id) {
        String sql = "select * from rentarea where buildingId = ? ";
        return query(sql , RentAreaModel.class , id);
    }

    @Override
    public int getTotalItemByBbuildingId(long id) {
        String sql = "select count(*) from rentarea where buildingId = ? ";
        return count(sql,id);
    }
}
