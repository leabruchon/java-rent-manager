package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;


@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	
	public VehicleService(VehicleDao vehicleDao) {
		super();
		this.vehicleDao = vehicleDao;
	}
	
	public long create(Vehicle vehicle) throws ServiceException {
		// TODO: créer un véhicule
		try {
			return this.vehicleDao.create(vehicle);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Vehicle findById(int id) throws ServiceException {
		// TODO: récupérer un véhicule par son id
		try {
			return this.vehicleDao.findById(id).get();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Vehicle> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.vehicleDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
