package com.example.adminside.servlet;

import com.example.adminside.model.BookingModel;
import com.example.adminside.model.EmpModel;
import com.example.adminside.model.UserModel;
import com.example.adminside.passwordHash.PasswordHashing;
import com.example.adminside.query.*;
import com.example.adminside.utils.SerializationUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List <BookingModel> allBookings = new ArrayList<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String hashedStoredPassword = EmpQuery.getStoredHashedPassword(username);
        String error = null;
        boolean loginValid = false;
//        boolean hasImg = CheckImageQuery.checkImg(emp.getEmpId());


        if (PasswordHashing.verifyPassword(password, hashedStoredPassword)) {

            EmpModel emp = LoginQuery.getUser(username, hashedStoredPassword);
            int totalUsers = CountQuery.getUserCount();
            int totalBookings = CountQuery.getBookingsCount();
            int pendingCount = CountQuery.getPendingCount();
            allBookings = AllBookingsQuery.getAllBookings();

            if (emp.getUsername() != null) {
                loginValid = true;

                HttpSession session = request.getSession();
                session.setAttribute("empName", emp.getFullName());
                session.setAttribute("empUsername", emp.getUsername());
                session.setAttribute("empRole", emp.getRole());
                request.setAttribute("userObj", emp);
                request.setAttribute("loginValid", loginValid);
                request.setAttribute("totalUsers", totalUsers);
                request.setAttribute("totalBookings", totalBookings);
                request.setAttribute("pendingCount", pendingCount);
                request.setAttribute("allBookings", allBookings);
//                request.setAttribute("img", hasImg);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                loginValid = false;
                error = "User not found!!";
                request.setAttribute("errorMsg", error);
                request.setAttribute("loginValid", loginValid);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            loginValid = false;
            error = "Invalid Credentials";

            request.setAttribute("errorMsg", error);
            request.setAttribute("loginValid", loginValid);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
