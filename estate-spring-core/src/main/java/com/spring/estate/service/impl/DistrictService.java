package com.spring.estate.service.impl;

import com.spring.estate.dto.DistrictDTO;
import com.spring.estate.entity.DistrictEntity;
import com.spring.estate.repository.DistrictRepository;
import com.spring.estate.service.IDistrictService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by https://github.com/kwanpham
 */
@Service
public class DistrictService implements IDistrictService {

    @Autowired
    private DistrictRepository dr;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DistrictDTO> findAll() {
        List<DistrictDTO> dtos = new ArrayList<>();
        dr.findAll().stream().forEach(districtEntity -> {
            dtos.add(modelMapper.map(districtEntity , DistrictDTO.class));
        });
        return dtos;

    }


}
