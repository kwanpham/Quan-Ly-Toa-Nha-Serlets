package com.quanlytoanha.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BuildingModel extends AbstractModel<BuildingModel> {


    private String name;
    private String districtCode;
    private String ward;
    private String street;
    private String structure;
    private int numberOfBasement;
    private double buildingArea;
    private String direction;
    private String levelBuilding;
    private String rentArea;
    private String areaDescription;
    private int costRent;
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
    private String note;
    private String link;
    private String location;
    private String image;
    private String[] buildingTypes;
    private List<UserModel> users;
    private String type ;

    public static final String tableName = "building";

    public enum BuildingTypes {

        TANGTRET("tang_tret" , "Tầng trệt"),
        NGUYENCAN("nguyen_can" , "Nguyên căn"),
        NOITHAT("noi_that" , "Nội thất");

        private String code , name ;

        BuildingTypes(String code, String name) {
            this.code = code;
            this.name = name;
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
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

    public int getCostRent() {
        return costRent;
    }

    public void setCostRent(int costRent) {
        this.costRent = costRent;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getCarCost() {
        return carCost;
    }

    public void setCarCost(String carCost) {
        this.carCost = carCost;
    }

    public String getMotorbikeCost() {
        return motorbikeCost;
    }

    public void setMotorbikeCost(String motorbikeCost) {
        this.motorbikeCost = motorbikeCost;
    }

    public String getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(String overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public String getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(String electricityCost) {
        this.electricityCost = electricityCost;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTimeContract() {
        return timeContract;
    }

    public void setTimeContract(String timeContract) {
        this.timeContract = timeContract;
    }

    public String getTimeDecorator() {
        return timeDecorator;
    }

    public void setTimeDecorator(String timeDecorator) {
        this.timeDecorator = timeDecorator;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }


    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
