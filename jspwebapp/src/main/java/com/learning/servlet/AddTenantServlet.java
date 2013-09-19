package com.learning.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTenantServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String apartmentNumber = request.getParameter("apartmentNumber");
		String roomNumber = request.getParameter("roomNumber");
		
	}

}
