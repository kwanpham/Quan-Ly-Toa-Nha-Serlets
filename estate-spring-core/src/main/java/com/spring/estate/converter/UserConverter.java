package com.spring.estate.converter;


import com.spring.estate.dto.UserDTO;
import com.spring.estate.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDTO(UserEntity entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
