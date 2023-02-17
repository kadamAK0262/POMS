package com.revature.poms.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.service.RegisterPageImpl;

public class Application {
	public static void main(String[] args) throws NumberFormatException, SQLException {
		Scanner input = new Scanner(System.in);
		RegisterPageImpl rp= new RegisterPageImpl();
		boolean check = false;
		while(!check) {
			check = rp.registrationAndLogin();
		}	
		Menu.m1(input);
	}
}
