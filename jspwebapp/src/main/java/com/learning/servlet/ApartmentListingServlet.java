package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.dao.ApartmentListingDAO;
import com.learning.domain.Apartment;
import com.learning.exceptions.ApartmentNotFoundException;

public class ApartmentListingServlet extends HttpServlet {
	
	private ApartmentListingDAO apartmentListingDao;
	private boolean isAvailable;
	
	public void init() throws ServletException {
		apartmentListingDao = new ApartmentListingDAO();
		isAvailable = false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String apartmentNumber = request.getParameter("apartmentNumber");
	    String roomNumber = request.getParameter("roomNumber");
	    String numberOfBedRooms = request.getParameter("numberOfBedRooms");
	    String rent = request.getParameter("apartmentRent");
	    String available = request.getParameter("available");
	    if("Yes".equals(available)) {
	    	isAvailable = true;
	    }
	    
	    apartmentListingDao = new ApartmentListingDAO();
	    //apartmentListingDao.save(apartmentNumber, roomNumber, numberOfBedRooms, rent, isAvailable);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Apartment> apartmentListings;
		try {
			apartmentListings = apartmentListingDao.getListings();
			request.setAttribute("apartmentListings", apartmentListings);
			RequestDispatcher rd = request.getRequestDispatcher("/showApartmentListings.jsp");
			rd.forward(request, response);
		} catch (ApartmentNotFoundException e) {
			// TODO Add better result for UI.
			e.printStackTrace();
		}
		
	}

}
