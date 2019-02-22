package com.quanlytoanha.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.Type;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.impl.BuildingService;
import com.quanlytoanha.utils.HttpUtil;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-building"})
public class BuildingAPI extends HttpServlet {

    private IBuildingService buildingService = new BuildingService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingModel buildingModel = HttpUtil.of(request.getReader()).toModel(BuildingModel.class);

        buildingModel = buildingService.save(buildingModel);
        objectMapper.writeValue(response.getOutputStream() , buildingModel);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BuildingModel buildingModel = HttpUtil.of(req.getReader()).toModel(BuildingModel.class);
        buildingModel = buildingService.update(buildingModel);
        mapper.writeValue(resp.getOutputStream() , buildingModel);
    }
}
