package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;

@Service
public class ReservationService {
	private ReservationDao reservationDao;
	
	public ReservationService(ReservationDao reservationDao) {
		super();
		this.reservationDao = reservationDao;
	}
	
	/*public long create(Vehicle vehicle) throws ServiceException {
		// TODO: créer un véhicule
		
	}

	public Vehicle findById(long id) throws ServiceException {
		// TODO: récupérer un véhicule par son id
		
	}*/

	public List<Reservation> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.reservationDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
