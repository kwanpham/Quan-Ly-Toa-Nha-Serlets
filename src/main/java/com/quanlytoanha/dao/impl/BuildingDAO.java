package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IBuildingDAO;
import com.quanlytoanha.mapper.AssignmentMapper;
import com.quanlytoanha.mapper.BuildingMapper;
import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;

import java.util.List;

public class BuildingDAO extends AbsstractDAO<BuildingModel> implements IBuildingDAO {


    @Override
    public Long save(BuildingModel buildingModel) {

        String sql = autoWriteInsertSQL("building");
        return insert(sql, buildingModel);

    }

    @Override
    public void update(BuildingModel buildingModel) {

        String sql = autoWriteUpdateSQL("building");
        update(sql, buildingModel);
    }



    @Override
    public void delete(long id) {
        String sql = "DELETE FROM building WHERE id = ?";
        delete(sql, id);
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from building";
        return count(sql);
    }

    @Override
    public BuildingModel findOne(long id) {
        String sql = "select * from building where id = ?" ;
        return query(sql, new BuildingMapper(), id).get(0);
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building");
        if (pageble.getSorter() != null) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), new BuildingMapper());
    }



}
