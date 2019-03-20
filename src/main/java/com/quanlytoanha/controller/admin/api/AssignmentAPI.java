package com.quanlytoanha.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlytoanha.model.AssignmentModel;
import com.quanlytoanha.service.IAssignmentService;
import com.quanlytoanha.service.impl.AssignmentService;
import com.quanlytoanha.utils.HttpUtil;

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

    @Override
    public void init() throws ServletException {
        super.init();
        assignmentService = new AssignmentService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        AssignmentModel model = HttpUtil.of(request.getReader()).toModel(AssignmentModel.class);
        long checkSave = assignmentService.save(model);

        if (checkSave > 0 )
            mapper.writeValue(response.getOutputStream() , "{'statusAssign': 'sucsses')");
        else
            mapper.writeValue(response.getOutputStream() , "{'statusAssign': 'fail')") ;
    }


}
