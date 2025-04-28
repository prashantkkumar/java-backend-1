package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(
    description = "Login Servlet testing",
    urlPatterns = { "/LoginServlet" },  
    initParams = {
        @WebInitParam(name = "user", value = "Ashu"),
        @WebInitParam(name = "password", value = "Ashu8950#")
    }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get request parameters for userId and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        // Validate name (starts with capital and at least 3 characters)
        if (user == null || !user.matches("^[A-Z][a-zA-Z]{2,}$")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");  // Correct path to HTML page
            out.println("<font color='red'>Invalid Name. Name must start with a capital letter and be at least 3 characters long.</font>");
            rd.include(request, response);
            return;
        }
        if (pwd == null || !pwd.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");  // Correct path to HTML page
            out.println("<font color='red'>Invalid Password. Must be at least 8 characters long, contain one uppercase letter, one number, and exactly one special character.</font>");
            rd.include(request, response);
            return;
        }

        // Get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        // Validate login
        if (userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);  // Correct path to JSP page
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");  // Correct path to HTML page
            out.println("<font color='red'>Either username or password is incorrect.</font>");
            rd.include(request, response);
        }
    }
}
