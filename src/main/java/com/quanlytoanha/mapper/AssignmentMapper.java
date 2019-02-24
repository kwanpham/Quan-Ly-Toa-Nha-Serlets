package com.quanlytoanha.mapper;



import com.quanlytoanha.model.AssignmentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentMapper implements RowMapper<AssignmentModel> {
    @Override
    public AssignmentModel mapRow(ResultSet rs) {
        try {
            AssignmentModel assignmentModel = new AssignmentModel();
            assignmentModel.setUserId(rs.getLong("userId"));
            assignmentModel.setBuildingId(rs.getLong("buildingId"));
            assignmentModel.setCreatedDate(rs.getTimestamp("createdDate"));
            assignmentModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            assignmentModel.setCreatedBy(rs.getString("createdBy"));
            assignmentModel.setModifiedBy(rs.getString("modifiedBy"));
            return assignmentModel;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
