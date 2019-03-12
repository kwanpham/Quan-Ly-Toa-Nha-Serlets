package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.IAssignmentDAO;
import com.quanlytoanha.dao.IUserDAO;
import com.quanlytoanha.dao.impl.AssignmentDAO;
import com.quanlytoanha.dao.impl.UserDAO;
import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.model.UserModel;
import com.quanlytoanha.service.IUserService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {


    private IUserDAO userDAO;
    private IAssignmentDAO assignmentDAO;

    public UserService() {
        userDAO = new UserDAO();
        assignmentDAO = new AssignmentDAO();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName , password , status);
    }

    @Override
    public List<UserModel> findAll(){
        return userDAO.findAll();
    }

    @Override
    public List<UserModel> findByRoleId(long id) {
        return userDAO.findByRoleId(id);
    }

    @Override
    public List<UserModel> findUserAssignForBuilding(long roleId, long buildingId) {
        List<UserModel> userModels = userDAO.findByRoleId(roleId);
        List<AssignmentModel> assignmentModels = assignmentDAO.findByBuildingId(buildingId);



        for (UserModel userModel : userModels) {
            for (AssignmentModel assignmentModel : assignmentModels) {
                if (userModel.getId() == assignmentModel.getUserId()){
                    userModel.setChecked("checked");

                }
            }
        }
        return userModels;
    }
}
