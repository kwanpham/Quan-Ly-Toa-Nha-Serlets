package com.spring.estate.enums;

/**
 * Created by MyPC on 04/03/2019.
 */
public enum BuildingType {

    FURNTURE("Nội thất"),
    ROOTCAUSE("Nguyên căn"),
    BASEMENT("Tầng hầm");

    private String name;

    BuildingType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
