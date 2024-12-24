package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("susername");
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		String serviceRequest=request.getParameter("serviceRequest");
		
		Car c=new Car();
		c.setUsername(username);
		c.setCarRegistrationNumber(carRegistrationNumber);
		c.setServiceRequest(serviceRequest);
		
		int status=c.serviceRequest();
		if(status==1)
		{
			response.sendRedirect("/01-car-service-system/service-request-success.jsp");
		}
		else
		{
			response.sendRedirect("/01-car-service-system/service-request-failure.jsp");
		}
		
	}
}
