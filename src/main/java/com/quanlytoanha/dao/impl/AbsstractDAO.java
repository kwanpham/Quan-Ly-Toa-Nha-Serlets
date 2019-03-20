package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.GenericDAO;

import com.quanlytoanha.model.AbstractModel;

import org.apache.commons.lang3.ArrayUtils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        long checkInsert = 0;
        try {
            long id = 0;
            connection = getConnection();
            assert connection != null;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Object[] parameters = autoGetValueFromModel(model);
            setParameter(statement, parameters);
            System.out.println(statement.toString());
            checkInsert = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
                return id;
            }
            connection.commit();

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
            closeAll(connection, statement, resultSet);

        }
        return checkInsert;
    }

    @Override
    public void update(String sql, T model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);        // statement tính được số parameters khi truyền dấu '?'
            Object[] parameters = autoGetValueFromModel(model);
            parameters = ArrayUtils.add(parameters, model.getId());  // thêm id vào cuối cùng "where id = ? "
            setParameter(statement, parameters);
            System.out.println(statement.toString());
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
            closeAll(connection, statement, null);
        }
    }

    public void delete(String sql, Object... parameters) {
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
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            closeAll(connection, statement, null);
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
            closeAll(connection, statement, resultSet);
        }
    }




    public List<T> query(String sql, Class<T> tClass, Object... parameters) {
        List<T> results;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            this.setParameter(statement, parameters);
            resultSet = statement.executeQuery();

            results = autoMappingModel(resultSet, tClass);
            return results;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll(connection, statement, resultSet);
        }
    }


    private void closeAll(Connection conn, Statement sta, ResultSet rs) {
        try {
            conn.close();
            sta.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
                } else if (parameter instanceof Double) {
                    statement.setDouble(index, (Double) parameter);
                } else {
                    statement.setNull(index, Types.NULL);
                }
            }

            //System.out.println("parameters length at setpareameter() : " + parameters.length);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //lấy tên tất cả column trong 1 bảng
    private List<String> getAllColumnName(String table) {
        Connection connection = getConnection();
        try {
            List<String> listColumNames = new ArrayList<>();
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet = metadata.getColumns(null, null, table, null);

            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                listColumNames.add(name);

            }
            return listColumNames;


        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String autoWriteInsertSQL(String tableName) {

        List<String> listColumnName = getAllColumnName(tableName);
        int count = listColumnName.size();
        StringBuilder sql = new StringBuilder(" insert into " + tableName + " (  ");
        for (int i = 1; i < count; i++) {

            if(listColumnName.get(i).equals("id"))
                continue;

            if (i == count - 1) {
                sql.append(listColumnName.get(i) + " , ");
                sql.delete(sql.length() - 2, sql.length());
                sql.append(" )");
                break;
            }
            sql.append(listColumnName.get(i) + " , ");
        }


        sql.append(" values( ");


        for (int i = 1; i < count; i++) {

            if(listColumnName.get(i).equals("id"))
                continue;

            if (i == count - 1) {
                sql.append("? ) ");
            } else {
                sql.append("?, ");
            }
        }

        return sql.toString();
    }


    public String autoWriteUpdateSQL(String tableName) {
        List<String> listColumnName = getAllColumnName(tableName);
        int count = listColumnName.size();
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        for (int i = 1; i < count; i++) {
            if (i == count - 1) {
                sql.append(listColumnName.get(i) + " = ?  ");
            } else {
                sql.append(listColumnName.get(i) + " = ? , ");
            }
        }
        sql.append(" where id = ? ");
        System.out.println(sql.toString());
        return sql.toString();

    }


    // lấy tên tất cả các field trong 1 model
    private List<Field> getAllFieldFromModel(Class<T> aClazz) {
        Field private_nameFieldChildClass[] = aClazz.getDeclaredFields();
        Field private_nameFieldSuperClass[] = aClazz.getSuperclass().getDeclaredFields();
        List<Field> listField = new LinkedList<>(Arrays.asList(private_nameFieldChildClass));
        List<Field> listFieldSuperClass = new LinkedList<>(Arrays.asList(private_nameFieldSuperClass));
        listField.addAll(listFieldSuperClass);
        return listField;
    }

    // Lất tất cả value có trong field của model đẻ thực hiên câu lệnh insert , update
    private Object[] autoGetValueFromModel(T model) throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {

        List<Field> listField = this.getAllFieldFromModel((Class<T>) model.getClass());
        List<String> listColName = this.getAllColumnName(model.getClass().getField("tableName").get(null).toString());

        List<Object> objects = new ArrayList<>();

        for (String colName : listColName) {

            if (colName.equals("id")) {
                continue;
            }

            for (Field field : listField) {
                if (colName.equals(field.getName())) {
                    field.setAccessible(true);
                    Object temp = field.get(model);
                    if (temp != null) {
                        objects.add(temp);
                    } else {
                        objects.add(null);
                    }
                    break;
                }
            }
        }

        return objects.toArray();
    }

    private List<T> autoMappingModel(ResultSet rs, Class<T> aClazz) {

        List<T> results = new ArrayList<>();

        List<Field> listField = this.getAllFieldFromModel(aClazz);

        List<String> listColumnName = null;

        try {
            listColumnName = this.getAllColumnName(aClazz.getField("tableName").get(null).toString());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Map<String, Field> fieldMap = new HashMap<>();


        for (String colName : listColumnName) {
            for (Field field : listField) {
                if (colName.equals(field.getName())) {
                    fieldMap.put(colName, field);
                    break;
                }
            }
        }

        try {
            while (rs.next()) {
                T model = aClazz.getConstructor().newInstance();
                for (Map.Entry<String, Field> entity : fieldMap.entrySet()) {
                    mapResultSetToModel(entity.getKey(), entity.getValue(), model, rs);
                }
                results.add(model);
            }

            return results;
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void mapResultSetToModel(String colName, Field field, T model, ResultSet rs) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        field.set(model, rs.getObject(colName, field.getType()));
    }


}
