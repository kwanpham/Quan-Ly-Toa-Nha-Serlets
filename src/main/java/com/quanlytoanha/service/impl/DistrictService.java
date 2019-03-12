package com.quanlytoanha.service.impl;

import com.quanlytoanha.dao.impl.DistrictDAO;
import com.quanlytoanha.model.DistrictModel;
import com.quanlytoanha.service.IDistrictService;

import java.util.List;

/**
 * Created by K.Wan on 07/03/2019.
 */
public class DistrictService implements IDistrictService {

    @Override
    public List<DistrictModel> findAll() {
        DistrictDAO districtDAO = new DistrictDAO();
        return districtDAO.findAll();
    }
}
