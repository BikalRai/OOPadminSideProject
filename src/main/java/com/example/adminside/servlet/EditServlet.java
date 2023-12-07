package com.example.adminside.servlet;

import com.example.adminside.model.EmpModel;
import com.example.adminside.query.EmpQuery;
import com.example.adminside.utils.DispatcherUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(name = "EditServlet", value = "/editEmp")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));

        EmpModel emp = new EmpModel();
        emp.setFullName(request.getParameter("name"));
        emp.setUsername(request.getParameter("username"));
        emp.setPassword(request.getParameter("password"));
        emp.setRole(request.getParameter("role"));
        emp.setMobile(request.getParameter("mobile"));
        emp.setEmail(request.getParameter("email"));
        emp.setJoinDate(request.getParameter("date"));
        emp.setStatus(request.getParameter("status"));
        emp.setEmpId(id);

        System.out.println(emp.getStatus());

        String message = null;

        if (emp.getUsername() != null) {
            EmpQuery.updateEmp(emp);
            message = "Successfully Updated";
            request.setAttribute("check", true);
            request.setAttribute("msg", message);
            request.setAttribute("emp", emp);
            new DispatcherUtil().dispatch(request, response, "./pages/emp-edit.jsp");
        } else {
            message = "Oops... Something went wrong";
            request.setAttribute("check", false);
            request.setAttribute("msg", message);
            request.setAttribute("emp", emp);
            new DispatcherUtil().dispatch(request, response, "./pages/emp-edit.jsp");
        }
    }
}
