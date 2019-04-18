package com.spring.estate.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserDTO extends BaseDTO<UserDTO> {


    private String userName;


    private String password;


    private String fullName;


    private Integer status;
}
