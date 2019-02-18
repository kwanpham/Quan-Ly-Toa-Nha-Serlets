package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.GenericDAO;
import com.quanlytoanha.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbsstractDAO<T> implements GenericDAO<T> {

//    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
//
//    public Connection getConnection() {
//        try {
//            Class.forName(resourceBundle.getString("driverName"));
//            String url = resourceBundle.getString("url");
//            String user = resourceBundle.getString("user");
//            String password = resourceBundle.getString("password");
//            return DriverManager.getConnection(url, user, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    public Connection getConnection() {
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

    @Override
    public  List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Update thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            long id =0;
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            System.out.println(statement.toString());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }


    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                } else {
                    statement.setNull(index, Types.NULL);
                }
            }

            System.out.println(parameters.length + " //// " );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected String autoWriteUpdateSQL(String table) {
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
            return sql.toString();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String autoWriteInsertSQL(String table) {
        Connection connection = getConnection();
        int start;
        if (table.toLowerCase().contains("detail")){
            start=1;
        }else {
            start=2;
        }
        try {
            PreparedStatement statement = connection.prepareStatement("select *from " + table);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();
            System.out.println("Column Count : " + count);
            StringBuilder sql = new StringBuilder(" insert into " + rsmd.getTableName(1) + " (  ");
            for (int i = start; i <= count; i++) {

                if (i == count) {
                    sql.append(rsmd.getColumnName(i) + " , ");
                    sql.delete(sql.length() - 2, sql.length());
                    sql.append(" )");
                    break;
                }

                sql.append(rsmd.getColumnName(i) + " , ");

            }

            sql.append(" values( ");


            for (int i = start; i <= count; i++) {

                if (i == count) {
                    sql.append("? ) ");
                } else {
                    sql.append("?, ");
                }
            }

            return sql.toString();


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }


}
