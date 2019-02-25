package com.quanlytoanha.dao;

import com.quanlytoanha.model.AssignmentModel;

import java.util.List;

/**
 * Created by MyPC on 25/02/2019.
 */
public interface IAssignmentDAO extends GenericDAO<AssignmentModel> {

    long save(AssignmentModel model);

    @SuppressWarnings("long buildingId , long userId")
    void deleteByBuildingUserId(long buildingId , long userId);

    List<AssignmentModel> findByBuildingId(long id);

    List<AssignmentModel> findByUserId(long id);
}
