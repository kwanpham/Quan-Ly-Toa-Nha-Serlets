package com.spring.estate.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * Created by https://github.com/kwanpham
 */
@Getter
@Setter
public class BuildingDTO extends BaseDTO<BuildingDTO> {


    private String name;


    private String district;


    private String ward;


    private String street;


    private String structure;


    private Integer numberOfBasement;


    private Double buildingArea;


    private String direction;


    private String levelBuilding;


    private String[] rentArea;


    private String areaDescription;


    private Integer costRent;


    private String costDescription;


    private String serviceCost;


    private String carCost;


    private String motorbikeCost;


    private String overtimeCost;


    private String electricityCost;


    private String deposit;


    private String payment;

    private String timeContract;


    private String timeDecorator;


    private String managerName;


    private String managerPhone;

    private String commission;

    private String[] buildingTypes;

    private String note;

    private String link;

    private String location;

    private String image;

    private String type;


}
