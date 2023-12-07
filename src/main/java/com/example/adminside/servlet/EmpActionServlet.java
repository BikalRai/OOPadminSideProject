package com.example.adminside.servlet;

import com.example.adminside.model.EmpModel;
import com.example.adminside.query.EmpQuery;
import com.example.adminside.utils.DispatcherUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpActionServlet", value = "/empAction")
public class EmpActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String actionValues = request.getParameter("action");
        String[] actionArr = actionValues.split(",");
        String action = actionArr[0];
        String username = actionArr[1].trim();

        EmpModel emp = EmpQuery.getEmp(username);


        List<EmpModel> allEmp = new ArrayList<>();
        allEmp = EmpQuery.getAllEmp();


        if (action.equalsIgnoreCase("view")) {
            request.setAttribute("emp", emp);
            new DispatcherUtil().dispatch(request, response, "./pages/view-emp.jsp");
        }

        if (action.equalsIgnoreCase("back")) {
            request.setAttribute("allEmp", allEmp);
            new DispatcherUtil().dispatch(request, response, "./pages/emp.jsp");
        }

        if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("emp", emp);
            new DispatcherUtil().dispatch(request, response, "./pages/emp-edit.jsp");
        }


    }
}
