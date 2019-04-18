package com.spring.estate.service.impl;

import com.spring.estate.dto.BuildingDTO;
import com.spring.estate.entity.BuildingEntity;
import com.spring.estate.enums.BuildingType;
import com.spring.estate.repository.BuildingRepository;
import com.spring.estate.service.IBuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by https://github.com/kwanpham
 */
@Service
public class BuildingService implements IBuildingService {

    @Autowired
    BuildingRepository br;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BuildingDTO save(BuildingDTO dto) {
        BuildingEntity be = br.save(modelMapper.map(br , BuildingEntity.class));
        return modelMapper.map(be , BuildingDTO.class);
    }

    @Override
    public BuildingDTO update(BuildingDTO dto) {
        return null;
    }

    @Override
    public void delete(long[] ids) {

    }

    @Override
    public Map<String, String> getBuildTypes() {
        Map<String, String> results = new HashMap<>();
        // dùng stream put vào map
        Stream.of(BuildingType.values()).forEach(buildingType -> {
            results.put(buildingType.name(), buildingType.getName());
        });

        return results;
    }

    @Override
    public long getTotalItem() {
        return br.count();
    }

    @Override
    public BuildingDTO findOne(long id) {
        return modelMapper.map(br.findOne(id), BuildingDTO.class);
    }

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingDTO> dtos = new ArrayList<>();
        br.findAll().stream().forEach(
                buildingEntity -> {
                    dtos.add(modelMapper.map(buildingEntity , BuildingDTO.class));
                }
        );
        return dtos;
    }
}
