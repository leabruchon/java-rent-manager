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
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars")
public class VehicleListServlet extends HttpServlet{
	
	@Autowired
	VehicleService vehicleService;
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
				ArrayList<Vehicle> vehicleList = (ArrayList<Vehicle>) vehicleService.findAll();
	            request.setAttribute("cars", vehicleList);
				//request.setAttribute("ClientListServlet", this.clientService.findAll());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("./WEB-INF/views/vehicles/list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			Vehicle vehicle = new Vehicle(Integer.parseInt(request.getParameter("id")), null, null, (byte) 0);
			try {
				
				List<Reservation> reservation = reservationService.findVehicleById(Integer.parseInt(request.getParameter("id")));
				System.out.println(reservation);
				
				for(int i = 0; i<reservation.size();i++){
					reservationService.delete(reservation.get(i));
					
				}
				vehicleService.delete(vehicle);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
                
        doGet(request, response);
    }
}
