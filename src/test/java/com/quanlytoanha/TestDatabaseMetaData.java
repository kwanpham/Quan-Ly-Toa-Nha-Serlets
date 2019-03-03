package com.quanlytoanha;

import com.quanlytoanha.utils.SqlUtils;
import org.testng.annotations.Test;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * Created by MyPC on 01/03/2019.
 */
public class TestDatabaseMetaData {

    @Test
    public void showColumeName() throws Exception{

        DatabaseMetaData metadata = SqlUtils.getConnection().getMetaData();
        ResultSet resultSet = metadata.getColumns(null, null, "building", null);
        while (resultSet.next()) {
            String name = resultSet.getString("COLUMN_NAME");
            String type = resultSet.getString("TYPE_NAME");
            int size = resultSet.getInt("COLUMN_SIZE");

            System.out.println(name+" ");
        }
    }
}
