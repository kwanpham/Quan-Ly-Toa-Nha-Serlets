package com.spring.estate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String district;

    @Column
    private String ward;

    @Column
    private String street;

    @Column
    private String structure;

    @Column
    private int numberOfBasement;

    @Column
    private double buildingArea;

    @Column
    private String direction;

    @Column
    private String levelBuilding;

    @Column(columnDefinition = "TEXT")
    private String[] rentArea;

    @Column(columnDefinition = "TEXT")
    private String[] areaDescription;

    @Column
    private int costRent;

    @Column(columnDefinition = "TEXT")
    private String costDescription;

    @Column
    private String serviceCost;

    @Column
    private String carCost;

    @Column
    private String motorbikeCost;

    @Column
    private String overtimeCost;

    @Column
    private String electricityCost;

    @Column
    private String deposit;

    @Column
    private String payment;

    @Column
    private String timeContract;

    @Column
    private String timeDecorator;

    @Column
    private String managerName;

    @Column
    private String managerPhone;

    @Column
    private String commission;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column
    private String link;

    @Column
    private String location;

    @Column
    private String image;

    @Column(columnDefinition = "TEXT")
    private String[] type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignment", joinColumns = {
            @JoinColumn(name = "building_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", nullable = false)})
    private List<UserEntity> staffs = new ArrayList<>();


}
