package com.quanlytoanha.model;

public class RoleModel extends AbstractModel<RoleModel> {


    private String name;
    private int status;

    public static final String tableName = "role";


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
