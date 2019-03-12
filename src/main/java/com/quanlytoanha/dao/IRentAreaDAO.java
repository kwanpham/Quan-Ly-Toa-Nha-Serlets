package com.quanlytoanha.dao;

import com.quanlytoanha.model.RentAreaModel;
import com.quanlytoanha.model.RoleModel;

import java.util.List;

/**
 * Created by K.Wan on 07/03/2019.
 */
public interface IRentAreaDAO extends GenericDAO<RentAreaModel> {

    Long save(RentAreaModel model);

    void update(RentAreaModel model);

    void delete(long id);

    List<RentAreaModel> findByBuildingId(long id);

    int getTotalItemByBbuildingId(long id);

}
