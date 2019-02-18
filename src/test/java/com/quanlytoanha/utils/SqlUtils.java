package com.quanlytoanha.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 17/02/2019.
 */
public class SqlUtils {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quanlytoanha";
            String user = "root";
            String password = "123";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static List<String> getAllColumnName(String table) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select *from " + table);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();

            List<String> listColumNames = new ArrayList<>();
            for (int i = 1; i <= count; i++) {
                listColumNames.add(rsmd.getColumnName(i));

            }

            System.out.println(listColumNames.toString());
            return listColumNames;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
