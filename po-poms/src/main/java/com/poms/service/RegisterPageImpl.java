package com.poms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.app.Menu;
import com.revature.poms.config.DatabaseConnectivity;

public class RegisterPageImpl {
	
	private static final Logger log = Logger.getLogger(Menu.class);
	private static Connection conn = DatabaseConnectivity.getConnection();
	Scanner sc= new Scanner(System.in);
	int s;
	public boolean registrationAndLogin()
	{
		boolean check = false;
		log.info("==========Welcome Admin==========\n");	
		log.info("Press 1 to Register ");
		log.info("Press 2 for Login ");
		s=Integer.parseInt(sc.nextLine());
		switch(s)
		{
		case 1: 
			log.info("======Admin Registration page=======");
			log.info("Enter Name : ");
			String	Name=sc.nextLine();
			log.info("Enter Email : ");
			String	email=sc.nextLine();
			log.info("Enter the Phone no. : ");
			int mobile=Integer.parseInt(sc.nextLine());
			log.info("Enter the date of birth : ");
			String dob=sc.nextLine();
			log.info("Enter password : ");
			String password=sc.nextLine();
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement("insert into admin_reg(admin_name,admin_email,admin_phone,admin_dob,admin_password) values(?,?,?,?,?)");
				ps.setString(1, Name);
				ps.setString(2, email);
				ps.setInt(3, mobile);
				ps.setString(4, dob);
				ps.setString(5, password);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("Registered Sucessfully\n");
			return registrationAndLogin();
		case 2: 
			log.info("Enter name: ");
			String name=sc.nextLine();
			log.info("Enter password: ");
			String p=sc.nextLine();
			Statement s=null;
			ResultSet rs= null;
			try {
				s=conn.createStatement();
				rs=s.executeQuery("select * from admin_reg ");
				while(rs.next())
				{
					
					if(rs.getString(2).trim().equals(name.trim())&& rs.getString(6).equals(p.trim())) {
						check = true;
					}
				}
				if(!check)
					log.info("Login Unsuccessful!!");
				else
					log.info("Login Successful!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
			default:
			log.info("Wrong Entry!!! \n enter correct input");
			return registrationAndLogin();
		}
	}

}
