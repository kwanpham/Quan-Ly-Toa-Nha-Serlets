package com.quanlytoanha.autowrite;

import com.quanlytoanha.model.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static com.quanlytoanha.utils.SqlUtils.getAllColumnName;

/**
 * Created by MyPC on 18/02/2019.
 */
public class AutoWriteMapper {

    @org.testng.annotations.Test
    public void AutoWriteGetter() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {
        Class<RoleModel> aClazz = RoleModel.class;


        String table = "Role";
        List<String> sqlField = getAllColumnName(table);


        Field private_nameFieldChildClass[] = aClazz.getDeclaredFields();
        Field private_nameFieldSuperClass[] = aClazz.getSuperclass().getDeclaredFields();
        List<Field> list = new LinkedList<>(Arrays.asList(private_nameFieldChildClass));
        List<Field> list1 = new LinkedList<>(Arrays.asList(private_nameFieldSuperClass));
        list.addAll(list1);

        int legth = list.size();

        for (int i = 0; i < legth; i++) {
            list.get(i).setAccessible(true);
            for (int j = 0; j < sqlField.size(); j++) {
                if (list.get(i).getName().equals(sqlField.get(j))) {
                    String column = sqlField.get(j);

                    String type = setType(list.get(i).getType().toString());
                    String str = list.get(i).getName();
                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                    System.out.println(list.get(i).getType().toString());

                    //System.out.println(StringUtils.uncapitalize(aClazz.getSimpleName()) + ".set" + cap + "(rs.get" + type + "(\"" + column + "\"));");
                    sqlField.remove(j);
                    break;
                }
            }
        }
    }

    private String setType(String type) {
        switch (type) {
            case "int":
                return "Int";
            case "class java.lang.Integer":
                return "Int";
            case "class java.lang.Double":
                return "Double";
            case "double":
                return "Double";
            case "class java.lang.Long":
                return "Long";
            case "long":
                return "Long";
            case "class java.lang.String":
                return "String";
            case "class java.sql.Timestamp":
                return "Timestamp";
            default:
                return null;

        }
    }


}
