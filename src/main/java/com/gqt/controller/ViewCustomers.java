package com.gqt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;


public class ViewCustomers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c=new Customer();
		List<Customer> customerList=c.viewCustomers();
		HttpSession session=request.getSession();
		session.setAttribute("scustomerList", customerList);
		
		response.sendRedirect("/01-car-service-system/view-customers.jsp");
	}
   

}
