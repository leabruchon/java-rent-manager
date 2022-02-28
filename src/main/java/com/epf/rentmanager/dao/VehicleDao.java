package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class VehicleDao {
	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	
	/*
	public long create(Vehicle vehicle) throws DaoException {
		
	}

	public long delete(Vehicle vehicle) throws DaoException {
		
	}

	public Optional<Vehicle> findById(long id) throws DaoException {
	}*/

	public List<Vehicle> findAll() throws DaoException {
		List<Vehicle> vehicleList = new ArrayList<>(); 
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLES_QUERY);) {
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int vehicleId = rs.getInt("id");
					String constructeur = rs.getString("constructeur");
					byte nombrePlaces = rs.getByte("nb_places");
					
					Vehicle vehicle = new Vehicle(
							vehicleId, constructeur, nombrePlaces );
					vehicleList.add(vehicle);
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vehicleList;
	}
}
