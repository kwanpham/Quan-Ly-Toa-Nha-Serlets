package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.IAssignmentDAO;
import com.quanlytoanha.dao.impl.AssignmentDAO;
import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.service.IAssignmentService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by K.Wan on 12/03/2019.
 */
public class AssignmentService implements IAssignmentService {

    private IAssignmentDAO assignmentDAO = new AssignmentDAO();

    @Override
    public List<AssignmentModel> findByBuildingId(long buildingId) {
        return assignmentDAO.findByBuildingId(buildingId);
    }

    @Override
    public long save(AssignmentModel model) {
        model.setCreatedBy("Admin");
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return assignmentDAO.save(model);
    }

    @Override
    public void deleteByBuildingUserId(long buildingId, long userId) {
        assignmentDAO.deleteByBuildingUserId(buildingId , userId);
    }
}
