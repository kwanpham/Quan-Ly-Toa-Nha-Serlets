package com.quanlytoanha.service;

import com.quanlytoanha.model.UserModel;

public interface IUserService {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);
}

