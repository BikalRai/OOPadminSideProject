package com.example.adminside.servlet;

import com.example.adminside.model.BookingModel;
import com.example.adminside.model.EmpModel;
import com.example.adminside.model.UserModel;
import com.example.adminside.query.AllBookingsQuery;
import com.example.adminside.query.CountQuery;
import com.example.adminside.query.EmpQuery;
import com.example.adminside.query.UserQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NavServlet", value = "/nav")
public class NavServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("empUsername");

        List<BookingModel> allBookings = new ArrayList<>();
        allBookings = AllBookingsQuery.getAllBookings();
        List<EmpModel> allEmp = new ArrayList<>();

        allEmp = EmpQuery.getAllEmpNotAdmin(username);

        int totalUsers = CountQuery.getUserCount();
        int totalBookings = CountQuery.getBookingsCount();
        int pendingCount = CountQuery.getPendingCount();

        if (page.equalsIgnoreCase("home")) {

            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalBookings", totalBookings);
            request.setAttribute("pendingCount", pendingCount);
            request.setAttribute("allBookings", allBookings);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/dashboard.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("emp")) {

            request.setAttribute("allEmp", allEmp);


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/emp.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("create-emp")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/create-emp.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("back")) {
            request.setAttribute("allEmp", allEmp);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/emp.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("users")) {
            List<UserModel> allUsers = UserQuery.getAllUsers();

            request.setAttribute("allUsers", allUsers);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/users.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
