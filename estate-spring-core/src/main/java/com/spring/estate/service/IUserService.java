package com.spring.estate.service;


import com.spring.estate.dto.UserDTO;

public interface IUserService {
    UserDTO findOneByUserName(String name);
}
