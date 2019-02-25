package com.quanlytoanha.autowrite;

import com.quanlytoanha.dao.impl.BuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.quanlytoanha.utils.SqlUtils.getAllColumnName;

/**
 * Created by MyPC on 24/02/2019.
 */
public class AutoGetValueFromModel {

    @Test
    public void TestAutoGetValueFromModel() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {

        AutoGetValue(BuildingModel.class , "building");

    }

    private <T> void AutoGetValue(Class<T> aClazz , String tableName) throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {


        List<Object> objects = new ArrayList<>();


        List<String> sqlField = getAllColumnName(tableName);

        BuildingModel buildingModel = new BuildingModel();
        buildingModel.setName("ga");
        buildingModel.setStructure("Huong b");
        buildingModel.setDistrictCode("quan_1");
        buildingModel.setWard("An khanh");


        Field private_nameFieldChildClass[] = aClazz.getDeclaredFields();
        Field private_nameFieldSuperClass[] = aClazz.getSuperclass().getDeclaredFields();
        List<Field> listField = new LinkedList<>(Arrays.asList(private_nameFieldChildClass));
        List<Field> list1 = new LinkedList<>(Arrays.asList(private_nameFieldSuperClass));
        listField.addAll(list1);

        int legth = listField.size();

        for (int i = 0; i < legth; i++) {
            listField.get(i).setAccessible(true);
            for (int j = 0; j < sqlField.size(); j++) {
                if (listField.get(i).getName().equals(sqlField.get(j))) {
                    Object temp = listField.get(i).get(buildingModel);
                    if(temp != null){
                        objects.add(temp);
                    } else {

                        objects.add(null);
                    }

                    sqlField.remove(j);
                    break;
                }
            }
        }

        objects.toString();
    }


}
