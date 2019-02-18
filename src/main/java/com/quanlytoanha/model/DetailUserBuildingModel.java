package com.quanlytoanha.model;

public class DetailUserBuildingModel extends AbstractModel<DetailUserBuildingModel> {

    private long userId , buildingId ;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }


}
