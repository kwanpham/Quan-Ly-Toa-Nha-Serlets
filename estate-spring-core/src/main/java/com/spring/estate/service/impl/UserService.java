package com.spring.estate.service.impl;

import com.spring.estate.converter.UserConverter;
import com.spring.estate.dto.UserDTO;
import com.spring.estate.entity.UserEntity;
import com.spring.estate.repository.UserRepository;
import com.spring.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserName(String name) {
        UserEntity userEntity = userRepository.findOneByUserName(name);
        return userConverter.convertToDTO(userEntity);
    }
}
