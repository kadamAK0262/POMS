package com.revature.poms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.config.DatabaseConnectivity;
import com.revature.poms.model.Receptionist;

public class ReceptionistDaoImpl implements ReceptionistDao {

	private static final Logger log = Logger.getLogger(ReceptionistDaoImpl.class);

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

	public void getReceptionistDetails() {
		Connection conn = null;
		conn = DatabaseConnectivity.getConnection();
		String query = "select * from receptionist ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				log.info(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getString(4) + "--"
						+ rs.getNString(5) + "--" + rs.getString(6) + "--" + rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean getReceptionist_Id(int Receptionist_Id) {
		boolean isBoolean = false;
		String query = "select * from receptionist where receptionist_id = ?";
		try {
			PreparedStatement pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, Receptionist_Id);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				isBoolean = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isBoolean;
	}
	
	
	public void updateReceptionistDetails(int id,Scanner input) {
		String query;
		try {
			if (getReceptionist_Id(id)) {
				PreparedStatement preparedStmt = null;
				log.info("Press 1: update Receptionist Name");
				log.info("Press 2: update Designation )");
				log.info("Press 3: update Receptionist Gender");
				log.info("Press 4: update Receptionist shift timing");
				log.info("Press 5: update Receptionist Contact number");
				log.info("Press 6: update Receptionist Address");

				int value = Integer.parseInt(input.nextLine());
				switch (value) {
				case 1:

					log.info("Enter the Receptionist Name");
					String newInput = input.nextLine();
					query = "update receptionist set Receptionist_name = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
				case 2:
					log.info("Enter the Receptionist Designation");
					newInput = input.nextLine().toUpperCase();
					query = "update receptionist set Designation = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
				case 3:
					log.info("Enter Receptionist Gender");
					newInput = input.nextLine();
					query = "update receptionist set Gender = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
				case 4:
					log.info("Enter Receptionist Shift Time");
					newInput = input.nextLine();
					query = "update receptionist set Shift_time = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
				case 5:
					log.info("Enter Receptionist Contact number");
					int x = Integer.parseInt(input.nextLine());
					query = "update receptionnist set Contact_no = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setInt(1, x);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
				case 6:
					log.info("Enter Receptionist Address");
					newInput = input.nextLine();
					query = "update receptionist set Address = ? where Receptionist_Id = ?";
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info("updated successfully");
					break;
					
				default:
					log.info("Entered value is not correct");
					break;
				}
				preparedStmt.close();
			} else {
				log.info("pizza id does not exist");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
