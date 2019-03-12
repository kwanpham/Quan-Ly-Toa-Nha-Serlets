package com.quanlytoanha.service;

import com.quanlytoanha.model.AssignmentModel;

import java.util.List;

/**
 * Created by K.Wan on 12/03/2019.
 */
public interface IAssignmentService {

    List<AssignmentModel> findByBuildingId(long buildingId);

    long save(AssignmentModel model);

    void deleteByBuildingUserId(long buildingId, long userId);


}
