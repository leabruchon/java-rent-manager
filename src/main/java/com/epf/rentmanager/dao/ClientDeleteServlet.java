package com.epf.rentmanager.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/delete")
public class ClientDeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO

			//request.getRequestDispatcher("./WEB-INF/views/home.jsp").forward(request, response);
		
		
		PrintWriter out = response.getWriter();
        out.println("Id is: " + request.getParameterValues("mydata"));
	}

	

}
