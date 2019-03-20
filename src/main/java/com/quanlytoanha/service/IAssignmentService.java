package com.quanlytoanha.service;

import com.quanlytoanha.model.AssignmentModel;

import java.util.List;


public interface IAssignmentService {

    List<AssignmentModel> findByBuildingId(long buildingId);

    long save(AssignmentModel model);

    void deleteByBuildingUserId(long buildingId, long userId);

}
