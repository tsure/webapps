package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -1699363927567433810L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String group = request.getParameter("group");
	    String pass = request.getParameter("pass");
	    // ...
	    PrintWriter pw = response.getWriter();
	    pw.println("Name is: "+name);
	    pw.println("Group is: "+group);
	    pw.println("Pass is: "+pass);
	}

}
