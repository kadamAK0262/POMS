package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.poms.model.Receptionist;

public interface ReceptionistDao {
	public void addReceptionistDetails(Receptionist recept) throws SQLException;
	public void removeReceptionistDetails(int id) throws SQLException;
	public List<Receptionist> getReceptionistDetails();
	public void updateReceptionistDetails(int id,Receptionist receptionist);
}



