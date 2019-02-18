package com.quanlytoanha.model;

public class BuildingTypeModel extends AbstractModel<BuildingTypeModel> {

    private long buildingTypeId;
    private String name;
    private int status;

    public long getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(long buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
