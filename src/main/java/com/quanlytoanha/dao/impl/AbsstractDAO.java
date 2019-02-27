package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.GenericDAO;
import com.quanlytoanha.mapper.RowMapper;
import com.quanlytoanha.model.AbstractModel;
import org.apache.commons.lang3.ArrayUtils;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class AbsstractDAO<T extends AbstractModel> implements GenericDAO<T> {

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

    private Connection getConnection() {
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
    public long insert(String sql, T model) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            long id = 0;
            connection = getConnection();
            assert connection != null;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Object[] parameters = autoGetValueFromModel(model , model.getTableName());
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
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
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
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
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
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
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
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public  void update(String sql, T model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            Object[] parameters = autoGetValueFromModel(model , model.getTableName());
            parameters = ArrayUtils.add(parameters , model.getId());
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Update thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
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



    public void delete(String sql , Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Delete thanh cong");
        } catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
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
            e.printStackTrace();
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
                e.printStackTrace();
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

            //System.out.println("parameters length at setpareameter() : " + parameters.length);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Class<Long> typeof(final long expr) {
        return Long.TYPE;
    }

    private List<String> getAllColumnName(String table) {
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

            //System.out.println(listColumNames.toString());
            return listColumNames;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    protected String autoWriteUpdateSQL(String tableName) {
        List<String> listColumnName = getAllColumnName(tableName);
        int count = listColumnName.size();
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        for (int i = 1; i < count; i++) {
            if (i == count-1) {
                sql.append(listColumnName.get(i) + " = ?  ");
            } else {
                sql.append(listColumnName.get(i) + " = ? , ");
            }
        }
        sql.append(" where id = ? ");
        System.out.println(sql.toString());
        return sql.toString();


    }

    protected String autoWriteInsertSQL(String tableName) {

        List<String> listColumnName = getAllColumnName(tableName);
        int count = listColumnName.size();
        StringBuilder sql = new StringBuilder(" insert into " + tableName + " (  ");
        for (int i = 1; i < count; i++) {

            if (i == count-1) {
                sql.append(listColumnName.get(i) + " , ");
                sql.delete(sql.length() - 2, sql.length());
                sql.append(" )");
                break;
            }
            sql.append(listColumnName.get(i) + " , ");
        }

        sql.append(" values( ");


        for (int i = 1; i < count; i++) {

            if (i == count-1) {
                sql.append("? ) ");
            } else {
                sql.append("?, ");
            }
        }

        return sql.toString();
    }

    private  Object[] autoGetValueFromModel(T model, String tableName) throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {

        Class<T> aClazz = (Class<T>) model.getClass();
        List<Object> objects = new ArrayList<>();
        List<String> sqlField = getAllColumnName(tableName);

        Field private_nameFieldChildClass[] = aClazz.getDeclaredFields();
        Field private_nameFieldSuperClass[] = aClazz.getSuperclass().getDeclaredFields();
        List<Field> listField = new LinkedList<>(Arrays.asList(private_nameFieldChildClass));
        List<Field> list1 = new LinkedList<>(Arrays.asList(private_nameFieldSuperClass));
        listField.addAll(list1);

        int legth = listField.size();

        for (int i = 0; i < legth; i++) {
            listField.get(i).setAccessible(true);
            for (int j = 1; j < sqlField.size(); j++) {
                if (listField.get(i).getName().equals(sqlField.get(j))) {
                    Object temp = listField.get(i).get(model);
                    if (temp != null) {
                        objects.add(temp);
                    } else {

                        objects.add(null);
                    }

                    sqlField.remove(j);
                    break;
                }
            }
        }

        return objects.toArray();
    }


}
