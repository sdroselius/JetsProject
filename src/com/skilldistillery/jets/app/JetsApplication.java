package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	private AirField airField = new AirField();
	private static Scanner scanner;

	// NO other fields! NO list of jets!

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		app.launch();

		scanner.close();
	}

	private void launch() {

		boolean keepGoing = true;
		do {
			displayUserMenu();
			String userChoice = scanner.nextLine();
			switch (userChoice) {
				case "0": case "q": case "Q": case "quit": case "Quit":
					System.out.println("Fair skies to you.");
					keepGoing = false;
					break;
				case "1":
					System.out.println("--- Listing all jets: ---");
					airField.listAllJets();
					break;
				case "2":
					System.out.println("--- Flying all jets: ---");
					airField.flyAllJets();
					break;
				case "3":
					System.out.println("--- Fastest jet: ---");
					Jet fastestJet = airField.getFastestJet();
					System.out.println(fastestJet);
					break;
				case "4":
					System.out.println("--- Longest range jet: ---");
					Jet longestRange = airField.getLongestRange();
					System.out.println(longestRange);
					break;
				case "5":
					System.out.println("--- Loading all cargo planes: ---");
					airField.loadCargo();
					break;
				case "6":
					System.out.println("--- Launching all fighter jets: ---");
					airField.dogfight();
					break;
				case "7":
					System.out.println("--- Add a new jet: ---");
					airField.listAllJets();
					break;
				case "8":
					System.out.println("--- Remove a jet: ---");
					airField.listAllJets();
					break;
				default:
					System.out.println("Invalid choice: " + userChoice);
					break;
			}
		}
		while (keepGoing);

	}

	private void displayUserMenu() {
		char pl = '\u2708';
		System.out.println("" + pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl);
		System.out.println(pl+" 1) List all jets             "+pl);
		System.out.println(pl+" 2) Fly all jets              "+pl);
		System.out.println(pl+" 3) Show fastest jet          "+pl);
		System.out.println(pl+" 4) Show longest range jet    "+pl);
		System.out.println(pl+" 5) Load all cargo planes     "+pl);
		System.out.println(pl+" 6) Dogfight!                 "+pl);
		System.out.println(pl+" 7) Add a jet to the fleet    "+pl);
		System.out.println(pl+" 8) Remove a jet              "+pl);
		System.out.println(pl+" 0) Exit                      "+pl);
		System.out.println("" + pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+pl+"\n\n");
	}

}
