package com.quanlytoanha.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlytoanha.service.IUserService;
import com.quanlytoanha.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by K.Wan on 12/03/2019.
 */
@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {

    private IUserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        long roleId = Long.parseLong(request.getParameter("roleId"));
        long building = Long.parseLong(request.getParameter("buildingId"));
        objectMapper.writeValue(response.getOutputStream() , userService.findUserAssignForBuilding(roleId , building));
    }
}
