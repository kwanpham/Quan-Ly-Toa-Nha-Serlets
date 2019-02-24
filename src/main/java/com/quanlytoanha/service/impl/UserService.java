package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.IUserDAO;
import com.quanlytoanha.dao.impl.UserDAO;
import com.quanlytoanha.model.UserModel;
import com.quanlytoanha.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {


    private IUserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName , password , status);
    }

    public List<UserModel> findAll(){
        return userDAO.findAll();
    }


}
