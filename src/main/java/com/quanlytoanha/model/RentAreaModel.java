package com.quanlytoanha.model;

/**
 * Created by K.Wan on 07/03/2019.
 */
public class RentAreaModel extends AbstractModel<RentAreaModel> {

    private long buildingId;
    private double rentArea ;
    private String areaDescription;

    public static final String tableName = "rentarea";

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public double getRentArea() {
        return rentArea;
    }

    public void setRentArea(double rentArea) {
        this.rentArea = rentArea;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }
}
