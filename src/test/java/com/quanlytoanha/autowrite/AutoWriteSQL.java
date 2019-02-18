package com.quanlytoanha.autowrite;


import com.quanlytoanha.model.*;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;


import java.lang.reflect.Field;

import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static com.quanlytoanha.utils.SqlUtils.getAllColumnName;
import static com.quanlytoanha.utils.SqlUtils.getConnection;


public class AutoWriteSQL {

    String table= "district" ;

    @Test
    public void autoWriteUpdateSQL() {
        Connection connection = getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("select *from " + table);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();
            StringBuilder sql = new StringBuilder("update " + rsmd.getTableName(1) + " set ");
            for (int i = 2; i <= count; i++) {

                if (i == count) {
                    sql.append(rsmd.getColumnName(i) + " = ?  ");
                } else {
                    sql.append(rsmd.getColumnName(i) + " = ? , ");
                }


            }
            sql.append(" where buildingId = ? ");
            System.out.println(sql.toString());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void autoWriteInsertSQL() {
        Connection connection = getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("select *from " + table);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();
            System.out.println("Column Count : " + count);
            StringBuilder sql = new StringBuilder(" insert into " + rsmd.getTableName(1) + " (  ");
            for (int i = 2; i <= count; i++) {


                if (i == count) {
                    sql.append(rsmd.getColumnName(i) + " , ");
                    sql.delete(sql.length() - 2, sql.length());
                    sql.append(" )");
                    break;
                }

                sql.append(rsmd.getColumnName(i) + " , ");

            }

            sql.append(" values( ");


            for (int i = 2; i <= count; i++) {

                if (i == count) {
                    sql.append("? ) ");
                } else {
                    sql.append("?, ");
                }

            }


            System.out.println(sql.toString());


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }


    @org.testng.annotations.Test
    public void AutoWriteGetter() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {
        Class<?> aClazz = DetailUserBuildingModel.class;


        List<String> sqlField = getAllColumnName("detailuserbuilding");



        Field private_nameFieldChildClass[] = aClazz.getDeclaredFields();
        Field private_nameFieldSuperClass[] = aClazz.getSuperclass().getDeclaredFields();
        List<Field> list = new LinkedList<>(Arrays.asList(private_nameFieldChildClass));
        List<Field> list1 = new LinkedList<>(Arrays.asList(private_nameFieldSuperClass));
        list.addAll(list1);


        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getName());


        int legth = list.size();
        int count2 =0;


        StringBuilder getter = new StringBuilder("");
        Object[] objects = new Object[legth];
        for (int i = 1; i < legth; i++) {
            list.get(i).setAccessible(true);
            for (int j = 0; j < sqlField.size(); j++) {
                if (list.get(i).getName().equals(sqlField.get(j))) {
                    list.get(i).getType();
                    String str = list.get(i).getName();
                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                    getter.append(StringUtils.uncapitalize(aClazz.getSimpleName()) + ".get" + cap + "() ,");
                    count2++;
                    sqlField.remove(j);
                    break;
                }


            }


        }

        System.out.println(count2);
        System.out.println(sqlField.toString());
        System.out.printf(getter.toString());


    }


}
