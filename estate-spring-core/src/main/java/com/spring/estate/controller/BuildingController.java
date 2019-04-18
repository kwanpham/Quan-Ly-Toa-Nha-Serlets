package com.spring.estate.controller;

import com.spring.estate.constant.SystemConstant;
import com.spring.estate.dto.BuildingDTO;
import com.spring.estate.dto.DistrictDTO;
import com.spring.estate.service.IBuildingService;
import com.spring.estate.service.IDistrictService;
import com.spring.estate.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by https://github.com/kwanpham
 */
@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @GetMapping(value = "admin/building")
    public String listBuilding(Model model1 ) {
        model1.addAttribute("model", new BuildingDTO());

        return "admin/addbuilding";
    }

    @PostMapping(value = "admin/building")
    public String addBuilding( @ModelAttribute(SystemConstant.MODEL)BuildingDTO model) {
       buildingService.save(model);
        return "admin/addbuilding";
    }

    @ModelAttribute("BuildingStyleList")
    public Map<String, String> getBuildingStyleList() {
        return buildingService.getBuildTypes();
    }

    @ModelAttribute("districts")
    public List<DistrictDTO> getDistrict() {
        return districtService.findAll();
    }



}
