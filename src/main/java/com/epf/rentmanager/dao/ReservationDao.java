package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class ReservationDao {
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String COUNT_RESERVATIONS_QUERY = "SELECT COUNT(id) AS count FROM Reservation;"; 
	
	public long create(Reservation reservation) throws DaoException {
		long up = 0;
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_RESERVATION_QUERY);) {
			
			pstmt.setInt(1, reservation.getClient_id());
			pstmt.setInt(2, reservation.getVehicule_id());
			pstmt.setString(3, reservation.getDebut().toString());
			pstmt.setString(4, reservation.getFin().toString());
			
			
			up = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}
		return up; // renvoie 1 si le client est ajouté à la base
	}
	
	
	
	public long delete(Reservation reservation) throws DaoException {
		long up = 0;
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_RESERVATION_QUERY);) {
			
			pstmt.setInt(1, reservation.getId());
			up = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return up;
	}

	/*
	
	public List<Reservation> findResaByClientId(long clientId) throws DaoException {
		
	}
	
	public List<Reservation> findResaByVehicleId(long vehicleId) throws DaoException {
		 
	}*/

	public List<Reservation> findAll() throws DaoException {
		List<Reservation> reservationList = new ArrayList<>(); 
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);) {
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int reservationId = rs.getInt("id");
					int clientId = rs.getInt("client_id");
					int vehicleId = rs.getInt("vehicle_id");
					LocalDate debut = rs.getDate("debut").toLocalDate();
					LocalDate fin = rs.getDate("fin").toLocalDate();
					
					Reservation reservation = new Reservation(
							reservationId, clientId, vehicleId, debut, fin );
					reservationList.add(reservation);
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reservationList;
	}
	
	
	public int count(){
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_RESERVATIONS_QUERY);) {
				
			ResultSet rs  = pstmt.executeQuery();
			rs.next();
			int nbRents = rs.getInt("count");
		
			return nbRents;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
}

