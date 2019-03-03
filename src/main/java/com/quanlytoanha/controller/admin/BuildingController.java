package com.quanlytoanha.controller.admin;

import com.quanlytoanha.constant.SystemConstant;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.PageRequest;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.IUserService;
import com.quanlytoanha.service.impl.BuildingService;
import com.quanlytoanha.service.impl.UserService;
import com.quanlytoanha.sort.Sorter;
import com.quanlytoanha.utils.FormUtil;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {

    private BuildingModel model;

    private String view = "";

    private IBuildingService buildingService;
    private IUserService userService;


    @Override
    public void init() throws ServletException {
        super.init();
        buildingService = new BuildingService();
        userService = new UserService();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        model = FormUtil.toModel(BuildingModel.class , request);
        String ref = request.getParameter("ref");

        switch (ref) {
            case "add" :
                addBuilding(request , response);
                break;
            case "list" :
                showListBuilding(request , response);
                break;
            case "edit" :
                editBuilding(request , response);
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);

    }

    private void editBuilding(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("districts" , buildingService.findAllDistrict());
        request.setAttribute(SystemConstant.MODEL , buildingService.findOne(model.getId()));
        view = "views/admin/addbuilding.jsp";
    }

    private void showListBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                new Sorter(model.getSortName(), model.getSortBy()));

        model.setListResult(buildingService.findAll(pageble));
        model.setTotalItem(buildingService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        request.setAttribute(SystemConstant.USER , userService.findAll());
        view = "views/admin/listbuilding.jsp";

    }

    private void addBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("districts" , buildingService.findAllDistrict());
        view = "views/admin/addbuilding.jsp";

    }

}
