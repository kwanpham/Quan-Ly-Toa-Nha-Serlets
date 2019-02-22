package com.quanlytoanha.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BuildingModel extends AbstractModel<BuildingModel> {

    private long buildingId;
    private String name;
    private int districtId;
    private String ward;
    private String street;
    private String structure;
    private int numberOfBasement;
    private double buildingArea;
    private String direction;
    private String levelBuilding;
    private String rentArea;
    private String areaDescription;
    private double costRent;
    private String costDescription;
    private double serviceCost;
    private double carCost;
    private double motorbikeCost;
    private double overtimeCost;
    private double electricityCost;
    private double deposit;
    private double payment;
    private Timestamp timeContract;
    private Timestamp timeDecorator;
    private String managerName;
    private String mamagerPhone;
    private double commission;
    private String note;
    private String link;
    private String location;
    private String imageName;
    private String thumbnailBase64;
    private Integer status;
    private List<BuildingTypeModel> buildingTypes = new ArrayList<>();
    private List<UserModel> userModels;


    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public int getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(int numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevelBuilding() {
        return levelBuilding;
    }

    public void setLevelBuilding(String levelBuilding) {
        this.levelBuilding = levelBuilding;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public double getCarCost() {
        return carCost;
    }

    public void setCarCost(double carCost) {
        this.carCost = carCost;
    }

    public double getMotorbikeCost() {
        return motorbikeCost;
    }

    public void setMotorbikeCost(double motorbikeCost) {
        this.motorbikeCost = motorbikeCost;
    }

    public double getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(double overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public double getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Timestamp getTimeContract() {
        return timeContract;
    }

    public void setTimeContract(Timestamp timeContract) {
        this.timeContract = timeContract;
    }

    public Timestamp getTimeDecorator() {
        return timeDecorator;
    }

    public void setTimeDecorator(Timestamp timeDecorator) {
        this.timeDecorator = timeDecorator;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getMamagerPhone() {
        return mamagerPhone;
    }

    public void setMamagerPhone(String mamagerPhone) {
        this.mamagerPhone = mamagerPhone;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getThumbnailBase64() {
        return thumbnailBase64;
    }

    public void setThumbnailBase64(String thumbnailBase64) {
        this.thumbnailBase64 = thumbnailBase64;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BuildingTypeModel> getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(List<BuildingTypeModel> buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public List<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(List<UserModel> userModels) {
        this.userModels = userModels;
    }
}
