package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars/create")
public class VehicleCreateServlet extends HttpServlet{

	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO

			request.getRequestDispatcher("../WEB-INF/views/vehicles/create.jsp").forward(request, response);
		
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //request.getParameter("url");
        doGet(request, response);
    }
}
