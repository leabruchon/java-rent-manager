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
	
	public long create(Reservation reservation) throws ServiceException {
		// TODO: créer un véhicule
		try {
			return this.reservationDao.create(reservation);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public long delete(Reservation reservation) throws ServiceException{
		// TODO: créer un client
		try {
			return this.reservationDao.delete(reservation);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	

	public List<Reservation> findById(int id) throws ServiceException {
		// TODO: récupérer un véhicule par son id
			
			try {
				return this.reservationDao.findResaByClientId(id);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
	}
	
	public List<Reservation> findVehicleById(int id) throws ServiceException {
		// TODO: récupérer un véhicule par son id
			
			try {
				return this.reservationDao.findResaByVehicleId(id);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
	}

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
	
	public int count() throws ServiceException{
		
		return this.reservationDao.count();
	}
}
