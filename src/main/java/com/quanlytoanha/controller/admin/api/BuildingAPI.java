package com.quanlytoanha.controller.admin.api;

import com.quanlytoanha.service.IBuildingService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MyPC on 18/02/2019.
 */
@WebServlet(urlPatterns = {"/api-admin-building"})
public class BuildingAPI extends HttpServlet {

    @Inject
    private IBuildingService buildingService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
