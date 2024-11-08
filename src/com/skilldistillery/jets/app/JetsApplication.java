package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {
	
	private AirField airField = new AirField();
	private static Scanner scanner;
	
	// NO other fields!  NO list of jets!
 
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		app.launch();
		
		scanner.close();
	}

	private void launch() {
		// TODO Loop:
		// displayUserMenu()
		// get choice from scanner
		// act on choice
		
	}
	
	private void displayUserMenu() {
		// TODO sysouts for menu
	}

}
