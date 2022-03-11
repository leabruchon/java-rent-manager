package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;

@WebServlet("/users")
public class ClientListServlet extends HttpServlet {

	@Autowired
	ClientService clientService;
	@Autowired
	ReservationService reservationService;
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			// TODO
		
			try {
				ArrayList<Client> clientList = (ArrayList<Client>) clientService.findAll();
	            request.setAttribute("users", clientList);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("./WEB-INF/views/users/list.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			Client client = new Client(Integer.parseInt(request.getParameter("id")), ""  ,"" ,"",null );
			try {
				
				List<Reservation> reservation = reservationService.findById(Integer.parseInt(request.getParameter("id")));

				for(int i = 0; i<reservation.size();i++){
					reservationService.delete(reservation.get(i));
					
				}
				
				clientService.delete(client);

				
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
                
        doGet(request, response);
    }
}
