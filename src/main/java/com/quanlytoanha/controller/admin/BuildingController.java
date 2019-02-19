package com.quanlytoanha.controller.admin;

import com.quanlytoanha.model.DistrictModel;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.IUserService;
import com.quanlytoanha.service.impl.BuildingService;
import com.quanlytoanha.service.impl.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {

    @Inject
    private IBuildingService buildingService;

    @Inject
    private IUserService userService;

    String view = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type").toString();
        switch (type) {
            case "add" :
                addBuilding(request , response);
                break;
        }

    }

    private void showListBuilding() {

    }

    private void addBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("districts" , buildingService.findAllDistrict());
        request.setAttribute("buildingtypes" ,buildingService.findAllBuildingType());
        view = "view/admin/addbuilding.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);


    }

}
