package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;


public class CustomerLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Customer c=new Customer();
		c.setUsername(username);
		c.setPassword(password);
		int status=c.customerLogin();
		if(status==1)
		{
			String name=c.getName();
			HttpSession session=request.getSession();
			session.setAttribute("susername", username);
			session.setAttribute("sname", name);
			
			response.sendRedirect("/01-car-service-system/customer-login-success.jsp");
		}
		else if(status==0)
		{
			response.sendRedirect("/01-car-service-system/invalid-customer-username.jsp");
		}
		else
		{
			response.sendRedirect("/01-car-service-system/invalid-customer-password.jsp");
		}
	}

}
