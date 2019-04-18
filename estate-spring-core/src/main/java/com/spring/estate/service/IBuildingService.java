package com.spring.estate.service;

import com.spring.estate.dto.BuildingDTO;


import java.util.List;
import java.util.Map;

/**
 * Created by https://github.com/kwanpham
 */
public interface IBuildingService {

    BuildingDTO save(BuildingDTO dto);

    BuildingDTO update(BuildingDTO dto);

    void delete(long[] ids);

    Map<String, String> getBuildTypes() ;

    long getTotalItem();

    BuildingDTO findOne(long id);

    List<BuildingDTO> findAll();

}
