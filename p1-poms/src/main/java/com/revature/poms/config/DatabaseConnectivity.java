package com.revature.poms.config;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnectivity {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
	
			String dburl = "jdbc:mysql://localhost/poms_rev";
			String driver ="com.mysql.cj.jdbc.Driver";
			String username = "root";
			String password = "Akshay@0262";

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return connection;
}

}
