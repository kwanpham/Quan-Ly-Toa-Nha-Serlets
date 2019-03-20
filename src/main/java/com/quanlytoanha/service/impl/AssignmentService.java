package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.IAssignmentDAO;
import com.quanlytoanha.dao.impl.AssignmentDAO;
import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.service.IAssignmentService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        List<AssignmentModel> oldList = findByBuildingId(model.getBuildingId());
        List<Long> newList = new ArrayList<>();
        long checkSave = 0;

        for (int i = 0 ; i< model.getUserIds().length ; i++) {
            boolean checkOldAssisn = false;
            for (int j = 0 ; j<oldList.size() ; j++) {
                if (model.getUserIds()[i] == oldList.get(j).getUserId() ) {
                    oldList.remove(j);
                    checkOldAssisn = true;
                    break;
                }
            }

            if (!checkOldAssisn)
                newList.add(model.getUserIds()[i]);
        }

        for (AssignmentModel model1 : oldList) {
            deleteByBuildingUserId(model.getBuildingId() , model1.getUserId());
        }

        for (long userId : newList) {
            AssignmentModel temp = new AssignmentModel();
            temp.setBuildingId(model.getBuildingId());
            temp.setUserId(userId);
            temp.setCreatedBy("Admin");
            temp.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            checkSave += assignmentDAO.save(temp);
        }



        return checkSave;
    }

    @Override
    public void deleteByBuildingUserId(long buildingId, long userId) {
        assignmentDAO.deleteByBuildingUserId(buildingId , userId);
    }
}
