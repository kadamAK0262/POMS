package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.model.Receptionist;

public interface ReceptionistDao {
	public void addReceptionistDetails(Receptionist recept) throws SQLException;
	public void removeReceptionistDetails(int id) throws SQLException;
	public void getReceptionistDetails();
	public void updateReceptionistDetails(int id,Scanner input);
}

