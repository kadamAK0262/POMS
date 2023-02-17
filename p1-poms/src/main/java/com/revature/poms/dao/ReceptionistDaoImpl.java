package com.revature.poms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.poms.config.DatabaseConnectivity;
import com.revature.poms.model.Receptionist;

public class ReceptionistDaoImpl implements ReceptionistDao {


	private Connection conn = DatabaseConnectivity.getConnection();

	public void addReceptionistDetails(Receptionist recept) throws SQLException {

		PreparedStatement preparedStatement = null;
		String query = "insert into Receptionist(Receptionist_name, Designation,Gender, Shift_time, Contact_no,Address) values(?,?,?,?,?,?)";
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, recept.getReceptionistName());
		preparedStatement.setString(2, recept.getDesignation());
		preparedStatement.setString(3, recept.getGender());
		preparedStatement.setString(4, recept.getShiftTiming());
		preparedStatement.setNString(5, recept.getReceptionistContact());
		preparedStatement.setString(6, recept.getAddress());
		preparedStatement.executeUpdate();

	}

	public void removeReceptionistDetails(int id) throws SQLException {
		String query = "delete from receptionist where receptionist_id = ?";
		PreparedStatement pStatement = conn.prepareStatement(query);
		pStatement.setInt(1, id);
		pStatement.executeUpdate();
	}

	public List<Receptionist> getReceptionistDetails() {
		Connection conn = DatabaseConnectivity.getConnection();
		List<Receptionist> recptDetails = new ArrayList<Receptionist>();
		String query = "select * from receptionist ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Receptionist details = new Receptionist();
				details.setReceptId(rs.getInt(1));
				details.setReceptionistName(rs.getString(2));
				details.setDesignation(rs.getString(3));
				details.setGender(rs.getString(4));
				details.setShiftTiming(rs.getString(5));
				details.setReceptionistContact(rs.getString(6));
				details.setAddress(rs.getString(7));
				recptDetails.add(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recptDetails;

	}

	public Receptionist getReceptionist_Id(int Receptionist_Id) {
		boolean isBoolean = false;
		Receptionist receptionist = new Receptionist();
		String query = "select * from receptionist where receptionist_id = ?";
		try {
			PreparedStatement pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, Receptionist_Id);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				isBoolean = true;
				receptionist.setReceptionistName(resultSet.getString(1));
				receptionist.setDesignation(resultSet.getString(2));
				receptionist.setGender(resultSet.getString(3));
				receptionist.setShiftTiming(resultSet.getString(4));
				receptionist.setReceptionistContact(resultSet.getString(5));
				receptionist.setAddress(resultSet.getString(6));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (isBoolean) {
			return receptionist;
		}
		else {
			return null;
		}
	}
	
	
	public void updateReceptionistDetails(int id,Receptionist receptionist) {
		String query;
		query = "update receptionist set Receptionist_name = ?, Designation = ?, Gender = ?, Shift_time =?, Contact_no=?, Address =? where Receptionist_Id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, receptionist.getReceptionistName());
			ps.setString(2, receptionist.getDesignation());
			ps.setString(3, receptionist.getGender());
			ps.setString(4, receptionist.getShiftTiming());
			ps.setString(5, receptionist.getReceptionistContact());
			ps.setString(6, receptionist.getAddress());
			ps.setInt(7, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
}
