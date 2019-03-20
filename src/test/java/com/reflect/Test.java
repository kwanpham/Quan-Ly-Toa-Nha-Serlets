package com.reflect;

import com.quanlytoanha.dao.impl.BuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.utils.SqlUtils;

import java.lang.reflect.Field;

import java.util.List;





public class Test {





    @org.testng.annotations.Test
    public void Mapping() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {
        Class<BuildingModel> aClazz = BuildingModel.class;

        BuildingModel buildingModel = new BuildingModel();
        BuildingDAO buildingDAO = new BuildingDAO();
        buildingModel.setName("ga");

        buildingModel.setDistrictCode("quan_1");
        buildingModel.setWard("An khanh");
        List<String> sqlField = SqlUtils.getAllColumnName("building");

        int legth1 = sqlField.size();

        Field private_nameField[] = aClazz.getDeclaredFields();

        // Cho phép để truy cập vào các trường private.
        // Nếu không sẽ bị ngoại lệ IllegalAccessException
        int legth = private_nameField.length;
        int flag = 0;

        Object[] objects = new Object[legth];
        for (int i = 1; i < legth; i++) {
            private_nameField[i].setAccessible(true);
            for (int j = 0; j < legth1; j++) {
                if (private_nameField[i].getName().equals(sqlField.get(j))) {
                    objects[i] = private_nameField[i].get(buildingModel);
                   System.out.println(private_nameField[i].getName());

                    flag++;
                    break;
                }


            }
            if(flag==0){
                System.out.println("Khong trung nhau !!!!!!!!!!!!!!!!!!!!  " +private_nameField[i].getName().toLowerCase());
            } else {
                flag=0;
            }

        }

        String sql = "insert into  building (  name , district , ward , street , structure , numberofbasement , buildingarea , direction , level ," +
                " rentarea , areadescription , costrent , costdescription , servicecost , carcost , motorbikecost , overtimecost ," +
                " electricitycost , deposit , payment , timecontract , timedecorator , managername , mamagerphone , commission , note , link ," +
                " location , imagename , thumbnailbase64 , createddate , createdby  )" +
                " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) " ;

        //System.out.printf(buildingDAO.save(buildingModel) + "  thanh cong ");

        buildingModel.setStreet("Kakak");
        buildingModel.setId(1);
        buildingDAO.update(buildingModel);


    }

    @org.testng.annotations.Test
    public void testGetFinal() throws NoSuchFieldException, IllegalAccessException {
        String tableName = BuildingModel.class.getField("tableName").get(null).toString();
        System.out.println(tableName);
    }

    @org.testng.annotations.Test
    public void testArray() {
        Field[] fields = BuildingModel.class.getDeclaredFields();
    }

}
