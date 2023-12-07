package com.example.adminside.servlet;

import com.example.adminside.model.EmpModel;
import com.example.adminside.passwordHash.PasswordHashing;
import com.example.adminside.query.EmpQuery;
import com.example.adminside.query.LoginQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateEmpServlet", value = "/create-emp")
public class CreateEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String message = null;

        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String joinDate = request.getParameter("join_date");
        String status = request.getParameter("status");

        String hashedPassword = PasswordHashing.hashPassword(password);

//        String [] name = fullName.split(" ");
//        String firstName = name[0];
//        String lastName = name[1].trim();
//        String username = "" + firstName.charAt(0) + lastName.charAt(0) + firstName.charAt(firstName.length() - 1) + lastName.charAt(lastName.length() - 1);

        EmpModel empModel = new EmpModel();
        empModel.setFullName(fullName);
        empModel.setPassword(hashedPassword);
        empModel.setMobile(mobile);
        empModel.setEmail(email);
        empModel.setRole(role);
        empModel.setJoinDate(joinDate);
        empModel.setStatus(status);
        empModel.setUsername(username);

        System.out.println(empModel.getFullName());

        boolean empExist = EmpQuery.empExists(email);

        if (empExist) {
            message = "Emp already exists";
            request.setAttribute("check", false);
            request.setAttribute("empExistsErr", message);

            System.out.println(message);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/create-emp.jsp");
            requestDispatcher.forward(request, response);
        } else {
            EmpQuery.createEmp(empModel);

            message = "Created successfully...";
            System.out.println(message);


            request.setAttribute("empCreated", message);
            request.setAttribute("check", true);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/create-emp.jsp");
            requestDispatcher.forward(request, response);
        }



    }
}
