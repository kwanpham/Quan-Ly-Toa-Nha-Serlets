package com.spring.estate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String code;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();


}
