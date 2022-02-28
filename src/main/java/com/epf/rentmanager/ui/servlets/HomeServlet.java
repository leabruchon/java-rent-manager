package com.epf.rentmanager.ui.servlets;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO

			request.getRequestDispatcher("./WEB-INF/views/home.jsp").forward(request, response);
		
		/*
		PrintWriter out = response.getWriter();
        out.println("Sum is: " + 1);
        out.println("Average is: " + 1);*/
	}

}
