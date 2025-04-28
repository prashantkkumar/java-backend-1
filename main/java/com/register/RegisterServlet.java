package com.register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(username == null || email == null || password == null || username.isEmpty()|| email.isEmpty() ||password.isEmpty()) {
			   request.setAttribute("errorMessage", "All fields are required!");
			    RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp"); // <-- form page
			    dispatcher.forward(request, response);
			    return;
		}
		
		//storing to database
		
		request.setAttribute("username", username);
		request.setAttribute("email", email);
		request.setAttribute("fullname", fullname);

		RequestDispatcher dispatcher = request.getRequestDispatcher("registers_success.jsp");
		dispatcher.forward(request, response);
	}

}
