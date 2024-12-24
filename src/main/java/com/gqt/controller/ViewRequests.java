package com.gqt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;
import com.gqt.model.Customer;


public class ViewRequests extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Car c=new Car();
		List<Car> carDetails=c.viewCarDetails();
		HttpSession session=request.getSession();
		session.setAttribute("scarDetails", carDetails);
		
		response.sendRedirect("/01-car-service-system/view-requests.jsp");
	}
	}

