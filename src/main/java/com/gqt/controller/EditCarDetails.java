package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;


public class EditCarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		String carModel=request.getParameter("carModel");
		String carType=request.getParameter("carType");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("susername");
		
		Car c= new Car();
		c.setUsername(username);
		c.setCarRegistrationNumber(carRegistrationNumber);
		int status=c.editCarDetails();
		if(status==1)
		{
			response.sendRedirect("/01-car-service-system/edit-car-details-success.jsp");
		}
		else
		{
			response.sendRedirect("/01-car-service-system/edit-car-details-failure.jsp");
		}
		
	
	}

}
