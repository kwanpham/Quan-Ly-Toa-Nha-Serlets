package com.quanlytoanha.controller.admin.api;

import com.quanlytoanha.service.IAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MyPC on 27/02/2019.
 */
@WebServlet(urlPatterns = {"/api-admin-assignment"})
public class AssignmentAPI extends HttpServlet {

    private IAssignmentService assignmentService;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
