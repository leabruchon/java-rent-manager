package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet("/users/create")
public class ClientCreateServlet extends HttpServlet{
	@Autowired
	ClientService clientService;
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO
		
			
			request.setAttribute("dateMin", LocalDate.now().minusYears(90));
			request.setAttribute("dateMax", LocalDate.now().minusYears(18));

			request.getRequestDispatcher("../WEB-INF/views/users/create.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
		Client client = new Client(0, request.getParameter("last_name"),request.getParameter("first_name"),request.getParameter("email"), LocalDate.parse(request.getParameter("naissance")));
        try {
        	clientService.create(client);
            } catch (ServiceException e) {
            	e.printStackTrace();
            }
               doGet(request, response);
    }
}
