package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

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

@WebServlet("/users/update")
public class ClientUpdateServlet extends HttpServlet{
	@Autowired
	ClientService clientService;
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO
			try {
				Optional<Client> client = Optional.of(clientService.findById(Integer.parseInt(request.getParameter("id"))));
				request.setAttribute("user", client.get());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("../WEB-INF/views/users/update.jsp").forward(request, response);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	        
	        try {
	        	
	        	System.out.println(request.getParameter("last_name"));
	        	System.out.println(LocalDate.parse(request.getParameter("naissance")));
	        	//Optional<Client> client = Optional.of(clientService.findById(Integer.parseInt(request.getParameter("id"))));
		
	        	Client client = new Client(Integer.parseInt(request.getParameter("id")), request.getParameter("last_name"),request.getParameter("first_name"),request.getParameter("email"), LocalDate.parse(request.getParameter("naissance")));
				clientService.updateById(client);
				
			}  catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        doGet(request, response);
    }

}
