package com.quanlytoanha.controller.admin;

import com.quanlytoanha.constant.SystemConstant;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.PageRequest;
import com.quanlytoanha.paging.Pageble;
import com.quanlytoanha.service.IBuildingService;
import com.quanlytoanha.service.IDistrictService;
import com.quanlytoanha.service.IRentAreaService;
import com.quanlytoanha.service.IUserService;
import com.quanlytoanha.service.impl.BuildingService;
import com.quanlytoanha.service.impl.DistrictService;
import com.quanlytoanha.service.impl.RentAreaService;
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
    private IRentAreaService rentAreaService;
    private IUserService userService;
    private IDistrictService districtService;


    @Override
    public void init() throws ServletException {
        super.init();
        buildingService = new BuildingService();
        userService = new UserService();
        districtService = new DistrictService();
        rentAreaService = new RentAreaService();
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
            case "search" :
                break;
            default:
                showListBuilding(request, response);
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);

    }


    private void showListBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pageble pageble = new PageRequest(model.getPage(), 5,
                new Sorter(model.getSortName(), model.getSortBy()));

        model.setListResult(buildingService.findAll(pageble));
        model.setTotalItem(buildingService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / 5));
        request.setAttribute(SystemConstant.MODEL, model);
        request.setAttribute(SystemConstant.USER , userService.findAll());
        request.setAttribute("buildingTypes" , buildingService.getBuildTypes());
        request.setAttribute("districts" , districtService.findAll());
        request.setAttribute(SystemConstant.EMPLOYEES , userService.findByRoleId(SystemConstant.EMPLOYEESS_ROLE));
        view = "views/admin/listbuilding.jsp";

    }

    private void addBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("buildingTypes" , buildingService.getBuildTypes());
        request.setAttribute("districts" , districtService.findAll());
        view = "views/admin/addbuilding.jsp";

    }

    private void editBuilding(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("buildingTypes" , buildingService.getBuildTypes());
        request.setAttribute("districts" , districtService.findAll());
        request.setAttribute(SystemConstant.MODEL , buildingService.findOne(model.getId()));
        request.setAttribute("rentArea" , rentAreaService.findByBuildingId(model.getId()));
        view = "views/admin/addbuilding.jsp";
    }

    private void searchBuilding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pageble pageble = new PageRequest(model.getPage(), 5,
                new Sorter(model.getSortName(), model.getSortBy()));

        model.setListResult(buildingService.findAll(pageble));
        model.setTotalItem(buildingService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / 5));
        request.setAttribute(SystemConstant.MODEL, model);
        request.setAttribute(SystemConstant.USER , userService.findAll());
        request.setAttribute("buildingTypes" , buildingService.getBuildTypes());
        request.setAttribute("districts" , districtService.findAll());
        request.setAttribute(SystemConstant.EMPLOYEES , userService.findByRoleId(SystemConstant.EMPLOYEESS_ROLE));
        view = "views/admin/listbuilding.jsp";;
    }

}
