package com.quanlytoanha.model;

public class RoleModel extends AbstractModel<RoleModel> {


    private String name;

    public static final String tableName = "role";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
