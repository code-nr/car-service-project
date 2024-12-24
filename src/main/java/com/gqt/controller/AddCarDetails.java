package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class AddCarDetails extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("susername");
		String carModel=request.getParameter("carModel");
		String carType=request.getParameter("carType");
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		
		Car c=new Car();
		c.setUsername(username);
		c.setCarModel(carModel);
		c.setCarType(carType);
		c.setCarRegistrationNumber(carRegistrationNumber);
		int status=c.addCarDetails();
		if(status==1)
		{
			response.sendRedirect("/01-car-service-system/add-car-details-success.jsp");
		}
		else
		{
			response.sendRedirect("/01-car-service-system/add-car-details-failure.jsp");
		}
		
	}
}
