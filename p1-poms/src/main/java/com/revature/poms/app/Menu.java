package com.revature.poms.app;

import java.sql.SQLException;
import java.util.Scanner;

//import com.poms.service.RegisterPageImpl;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.ReceptionistDaoImpl;
import com.revature.poms.model.Receptionist;

public class Menu {

	public static void showMenu() {
		System.out.println(Constant.WELCOME_MESSAGE);
		System.out.println(Constant.INSERT_RECEPTIONIST);
		System.out.println(Constant.UPDATE_RECEPTIONIST);
		System.out.println(Constant.DELETE_RECEPTIONIST);
		System.out.println(Constant.SELECT_RECEPTIONIST);
	}

	public static void m1(Scanner input) throws NumberFormatException, SQLException {
		char value = 'N';
		do {
			int n = m2(input);
			if (n == 0) {
				System.out.println("To continue press Y otherwise press N");
			} else {
				m1(input);
			}
			try {
				value = input.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		} while (value == 'Y' || value == 'y');
	}

	public static int m2(Scanner input) {
		showMenu();
		ReceptionistDaoImpl receptionistData = new ReceptionistDaoImpl();
		int value = Integer.parseInt(input.nextLine());
		switch (value) {
		case 1:
			insertDetails(input, receptionistData);
			return 0;
		case 2:
			receptionistData.getReceptionistDetails();
			System.out.println("Enter the receptionist id");
			try {
				int x = Integer.parseInt(input.nextLine());
				if (receptionistData.getReceptionist_Id(x)) {
					receptionistData.updateReceptionistDetails(x, input);
				} else {
					System.out.println("id does not exist");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return 0;
		case 3:
			receptionistData.getReceptionistDetails();
			System.out.println("Enter the receptionist id from the above list");
			try {
				int x = Integer.parseInt(input.nextLine());
				if (receptionistData.getReceptionist_Id(x)) {
					receptionistData.removeReceptionistDetails(x);
					System.out.println("Deleted succesfully");
				} else {
					System.out.println("id does not exist");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return 0;
		case 4:
			receptionistData.getReceptionistDetails();
			return 0;
		default:
			return -1;
		}

	}

	public static void insertDetails(Scanner input, ReceptionistDaoImpl receptionistData) {
		Receptionist receptionist = new Receptionist();
		System.out.println(Constant.RECEPTIONIST_NAME);
		receptionist.setReceptionistName(input.nextLine());
		System.out.println(Constant.RECEPTIONIST_CONTACT);
		receptionist.setReceptionistContact(input.nextLine());
		System.out.println(Constant.RECEPTIONIST_DESIGNATION);
		receptionist.setDesignation(input.nextLine());
		System.out.println(Constant.RECEPTIONIST_GENDER);
		receptionist.setGender(input.nextLine());
		System.out.println(Constant.RECEPTIONIST_ADDRESS);
		receptionist.setAddress(input.nextLine());
		System.out.println(Constant.RECEPTIONIST_SHIFT_TIMING);
		receptionist.setShiftTiming(input.nextLine());
		try {
			receptionistData.addReceptionistDetails(receptionist);
			System.out.println("Data stored succesffuly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
