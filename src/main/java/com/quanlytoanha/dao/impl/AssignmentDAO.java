package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IAssignmentDAO;
import com.quanlytoanha.mapper.AssignmentMapper;
import com.quanlytoanha.model.AssignmentModel;

import java.util.List;

/**
 * Created by MyPC on 25/02/2019.
 */
public class AssignmentDAO extends AbsstractDAO<AssignmentModel> implements IAssignmentDAO {


    @Override
    public long save(AssignmentModel model) {
        String sql = autoWriteInsertSQL("assignment");
        return insert(sql, model);
    }

    @Override
    public void deleteByBuildingUserId(long buildingId, long userId) {
        String sql = "delete from assignment where buildingId= ? and userId = ?";
        delete(sql , buildingId , userId);
    }

    @Override
    public List<AssignmentModel> findByBuildingId(long buildingId) {
        String sql = "select *from assignment where buildingId = ?";
        return query(sql , new AssignmentMapper() , buildingId);
    }

    @Override
    public List<AssignmentModel> findByUserId(long userId) {
        String sql = "select *from assignment where userId = ?";
        return query(sql , new AssignmentMapper() , userId);
    }
}
