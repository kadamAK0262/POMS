package com.revature.poms.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws NumberFormatException, SQLException {
		Scanner input = new Scanner(System.in);
		Menu.m1(input);
	}
}
