package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class VehicleDao {
	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, modele, nb_places) VALUES( ?, ?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur,,  nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	
	
	public long create(Vehicle vehicle) throws DaoException {
		long up = 0;
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_VEHICLE_QUERY);) {
			
			pstmt.setString(1, vehicle.getConstructeur());
			pstmt.setString(2, vehicle.getModele());
			pstmt.setByte(3, vehicle.getNb_place());
			up = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return up;
	}

	
	public long delete(Vehicle vehicle) throws DaoException {
		long up = 0;
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_VEHICLE_QUERY);) {
			
			pstmt.setInt(1, vehicle.getId());
			up = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return up;
	}

	
	public Optional<Vehicle> findById(int id) throws DaoException {
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLE_QUERY);) {
				
				pstmt.setInt(1,id);
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				
				int vehicleId = rs.getInt(id);
				String vehicleConstructeur = rs.getString("constructeur");
				String vehicleModele = rs.getString("modele");
				Byte vehicleNbPlaces = rs.getByte("nb_place");
				
				Vehicle vehicle = new Vehicle(
						vehicleId, vehicleConstructeur,vehicleModele, vehicleNbPlaces);
				
				
				return Optional.of(vehicle);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  return  Optional.empty();
	}

	public List<Vehicle> findAll() throws DaoException {
		List<Vehicle> vehicleList = new ArrayList<>(); 
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLES_QUERY);) {
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int vehicleId = rs.getInt("id");
					String constructeur = rs.getString("constructeur");
					String modele = rs.getString("modele");
					byte nombrePlaces = rs.getByte("nb_places");
					
					Vehicle vehicle = new Vehicle(
							vehicleId, constructeur, modele, nombrePlaces );
					vehicleList.add(vehicle);
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vehicleList;
	}
}
