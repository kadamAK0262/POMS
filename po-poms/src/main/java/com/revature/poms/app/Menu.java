package com.revature.poms.app;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

//import com.poms.service.RegisterPageImpl;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.ReceptionistDaoImpl;
import com.revature.poms.model.Receptionist;

public class Menu {
	private static final Logger log = Logger.getLogger(Menu.class);

	public static void showMenu() {
		log.info(Constant.WELCOME_MESSAGE);
		log.info(Constant.INSERT_RECEPTIONIST);
		log.info(Constant.UPDATE_RECEPTIONIST);
		log.info(Constant.DELETE_RECEPTIONIST);
		log.info(Constant.SELECT_RECEPTIONIST);
	}

	public static void m1(Scanner input) throws NumberFormatException, SQLException {
		char value = 'N';
		do {
			int n = m2(input);
			if (n == 0) {
				log.info("To continue press Y otherwise press N");
			} else {
				m1(input);
			}
			try {
				value = input.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				log.info(e.getMessage());
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
			log.info("Enter the receptionist id");
			try {
				int x = Integer.parseInt(input.nextLine());
				if (receptionistData.getReceptionist_Id(x)) {
					receptionistData.updateReceptionistDetails(x, input);
				} else {
					log.info("id does not exist");
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
			return 0;
		case 3:
			receptionistData.getReceptionistDetails();
			log.info("Enter the receptionist id from the above list");
			try {
				int x = Integer.parseInt(input.nextLine());
				if (receptionistData.getReceptionist_Id(x)) {
					receptionistData.removeReceptionistDetails(x);
					log.info("Deleted succesfully");
				} else {
					log.info("id does not exist");
				}

			} catch (Exception e) {
				log.info(e.getMessage());
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
		log.info(Constant.RECEPTIONIST_NAME);
		receptionist.setReceptionistName(input.nextLine());
		log.info(Constant.RECEPTIONIST_CONTACT);
		receptionist.setReceptionistContact(input.nextLine());
		log.info(Constant.RECEPTIONIST_DESIGNATION);
		receptionist.setDesignation(input.nextLine());
		log.info(Constant.RECEPTIONIST_GENDER);
		receptionist.setGender(input.nextLine());
		log.info(Constant.RECEPTIONIST_ADDRESS);
		receptionist.setAddress(input.nextLine());
		log.info(Constant.RECEPTIONIST_SHIFT_TIMING);
		receptionist.setShiftTiming(input.nextLine());
		try {
			receptionistData.addReceptionistDetails(receptionist);
			log.info("Data stored succesffuly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}

	}

}
