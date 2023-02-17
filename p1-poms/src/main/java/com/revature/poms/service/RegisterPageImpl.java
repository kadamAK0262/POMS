package com.revature.poms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.poms.app.Menu;
import com.revature.poms.config.DatabaseConnectivity;

public class RegisterPageImpl {
	
	private static Connection conn = DatabaseConnectivity.getConnection();
	Scanner sc= new Scanner(System.in);
	int s;
	public boolean registrationAndLogin()
	{
		boolean check = false;
		System.out.println("==========Welcome Admin==========\n");	
		System.out.println("Press 1 to Register ");
		System.out.println("Press 2 for Login ");
		s=Integer.parseInt(sc.nextLine());
		switch(s)
		{
		case 1: 
			System.out.println("======Admin Registration page=======");
			System.out.println("Enter Name : ");
			String	Name=sc.nextLine();
			System.out.println("Enter Email : ");
			String	email=sc.nextLine();
			System.out.println("Enter the Phone no. : ");
			int mobile=Integer.parseInt(sc.nextLine());
			System.out.println("Enter the date of birth : ");
			String dob=sc.nextLine();
			System.out.println("Enter password : ");
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
			System.out.println("Registered Sucessfully\n");
			return registrationAndLogin();
		case 2: 
			System.out.println("Enter name: ");
			String name=sc.nextLine();
			System.out.println("Enter password: ");
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
					System.out.println("Login Unsuccessful!!");
				else
					System.out.println("Login Successful!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
			default:
			System.out.println("Wrong Entry!!! \n enter correct input");
			return registrationAndLogin();
		}
	}

}
