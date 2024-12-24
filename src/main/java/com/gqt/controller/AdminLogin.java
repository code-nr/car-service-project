package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gqt.model.Admin;



public class AdminLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Admin a=new Admin();
		a.setUsername(username);
		a.setPassword(password);
		int status=a.adminLogin();
		if(status==1)
		{
			response.sendRedirect("/01-car-service-system/admin-login-success.jsp");
		}
		else if(status==0)
		{
			response.sendRedirect("/01-car-service-system/invalid-admin-username.jsp");
		}
		else
		{
			response.sendRedirect("/01-car-service-system/invalid-admin-password.jsp");
		}
	}

}
