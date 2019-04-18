package com.spring.estate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String code;
}
