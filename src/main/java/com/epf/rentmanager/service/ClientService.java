package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.dao.ClientDao;

@Service
public class ClientService {

	public ClientService(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}


	private ClientDao clientDao;
	
	
	public long create(Client client) throws ServiceException{
		// TODO: créer un client
		try {
			return this.clientDao.create(client);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	

	public Client findById(int id) throws ServiceException {
		// TODO: récupérer un client par son id
		
		try {
			return this.clientDao.findById(id).get();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<Client> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.clientDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
