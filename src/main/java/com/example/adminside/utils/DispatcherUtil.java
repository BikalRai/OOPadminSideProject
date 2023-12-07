package com.example.adminside.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherUtil {
    public void dispatch (HttpServletRequest req, HttpServletResponse res, String url) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, res);
    }
}
