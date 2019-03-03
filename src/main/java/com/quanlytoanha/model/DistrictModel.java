package com.quanlytoanha.model;

public class DistrictModel extends AbstractModel<DistrictModel> {

    private String name , code;

    public static final String tableName = "district";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
