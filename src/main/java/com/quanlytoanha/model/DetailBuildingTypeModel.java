package com.quanlytoanha.model;

public class DetailBuildingTypeModel extends AbstractModel<DetailBuildingTypeModel> {

    private long buildingId , buildingTypeId;

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public long getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(long buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }
}
