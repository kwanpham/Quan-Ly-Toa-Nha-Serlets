package com.quanlytoanha.dao.impl;

import com.quanlytoanha.builder.BuildingSearcher;
import com.quanlytoanha.dao.IBuildingDAO;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BuildingDAO extends AbsstractDAO<BuildingModel> implements IBuildingDAO {


    @Override
    public Long save(BuildingModel buildingModel) {

        String sql = autoWriteInsertSQL("building");
        return insert(sql, buildingModel);

    }

    @Override
    public void update(BuildingModel buildingModel) {

        String sql = autoWriteUpdateSQL("building");
        update(sql, buildingModel);
    }


    @Override
    public void delete(long id) {
        String sql = "DELETE FROM building WHERE id = ?";
        delete(sql, id);
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from building";
        return count(sql);
    }

    @Override
    public BuildingModel findOne(long id) {
        String sql = "select * from building where id = ?";
        //return query(sql, new BuildingMapper(), id).get(0);
        return query(sql, BuildingModel.class, id).get(0);
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building where 1 ");
        if (pageble.getSorter() != null) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), BuildingModel.class);
    }

    @Override
    public List<BuildingModel> findAll(BuildingSearcher searcher, Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building where 1 ");
        if (pageble.getSorter() != null) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }

        return null;
    }

    private StringBuilder buildBuildingSearcherQuery(StringBuilder sql, BuildingSearcher searcher) {
        Field[] fields = BuildingSearcher.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldType = field.getType().getName();
            if (fieldType.equals("java.lang.String")) {
                String value = getValue(field, String.class, searcher);
                if (StringUtils.isNotBlank(value)) {
                    sql.append(" AND LOWER(" + field.getName().toLowerCase() + ") LIKE '%" + value.toLowerCase() + "%'");
                }
            } else if (fieldType.equals("java.lang.Integer")) {
                Integer value = getValue(field, Integer.class, searcher);
                if (value != null) {
                    sql.append(" AND " + field.getName() + " = " + value + "");
                }
            }
        }
        return sql;
    }

    private <T> T getValue(Field field, Class<T> type, BuildingSearcher searcher) {
        Object result = null;
        Method getter = getGetter(field,searcher);
        if (getter != null) {
            try {
                result = getter.invoke(searcher);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return type.cast(result);
    }

    private Method getGetter(Field field, BuildingSearcher searcher) {
        String getterName = "get" + StringUtils.capitalize(field.getName());
        try {
            return searcher.getClass().getMethod(getterName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
