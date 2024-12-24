package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class CheckStatus extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		
		Car c=new Car();
		c.setUsername(username);
		c.setCarRegistrationNumber(carRegistrationNumber);
		int status=c.checkStatus();
		if(status==1) 
		{
			String serviceStatus=c.getServiceStatus();
			session.setAttribute("sserviceStatus", serviceStatus);
			response.sendRedirect("/01-car-service-system/check-status-success.jsp");	
		}
		else
		{
			response.sendRedirect("/01-car-service-system/check-status-failure.jsp");
		}
	    
}
}
