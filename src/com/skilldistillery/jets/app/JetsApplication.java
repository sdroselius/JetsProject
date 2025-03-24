package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.BusinessJet;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.Gunship;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {
	
	// NO Jet collection in the app class!
	// ONLY an AirField
	
	private AirField airField = new AirField();
	private static Scanner scanner;

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
			case "1": case "L": case "l": 
				airField.displayFleet();
				break;			
			case "2": case "F": case "f": 
				airField.flyAllJets();
				break;			
			case "3":  
				Jet fastest = airField.getFastestJet();
				if (fastest != null) {
					System.out.println("\nFastest Jet: ");
					System.out.println(fastest);
				}
				break;			
			case "4":  
				Jet longestRange = airField.getLongestRangeJet();
				if (longestRange != null) {
					System.out.println("\nLongest Range Jet: ");
					System.out.println(longestRange);
				}
				break;			
			case "5":  
				airField.loadCargoJets();
				break;			
			case "6":  
				airField.sortyFighters();
				break;			
			case "7":  
				addNewJet();
				break;			
			case "8":  
				removeJet();
				break;			
			case "0": case "Q": case "q": case "E": case "e": case "X": case "x": 
				keepGoing = false;
				System.out.println(" ** Happy Landings! **");
				break;			
			default:
				throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}
		} while (keepGoing );
	}
	
	private void displayUserMenu() {
		System.out.println("+--------------AirField--------------+");
		System.out.println("|        Choose an operation         |");
		System.out.println("| 1) List all aircraft               |");
		System.out.println("| 2) Fly all aircraft                |");
		System.out.println("| 3) View fastest jet                |");
		System.out.println("| 4) View longest-range jet          |");
		System.out.println("| 5) Load cargo jets                 |");
		System.out.println("| 6) Sortie fighter jets             |");
		System.out.println("| 7) Add a jet to the fleet          |");
		System.out.println("| 8) Remove a jet from the fleet     |");
		System.out.println("| 0) Quit/Exit                       |");
		System.out.println("+------------------------------------+");
	}

	private void addNewJet() {
		System.out.println("What type of jet are you adding?");
		System.out.println("1) Business");
		System.out.println("2) Cargo");
		System.out.println("3) Fighter");
		System.out.println("4) Gunship (fighter/cargo)");
		String type = scanner.nextLine();
		System.out.print("Enter the jet model: ");
		String model = scanner.nextLine();
		System.out.print("Enter the speed in MPH: ");
		double speed = scanner.nextDouble();
		System.out.print("Enter the range in miles: ");
		int range = scanner.nextInt();
		System.out.print("Enter the price: ");
		long price = scanner.nextLong();
		scanner.nextLine(); //clear input buffer
		Jet newJet = null;
		switch(type) {
		case "1": case "b": case "B":
			newJet = new BusinessJet(model, speed, range, price);
			break;
		case "2": case "c": case "C":
			newJet = new CargoJet(model, speed, range, price);
			break;
		case "3": case "f": case "F":
			newJet = new CargoJet(model, speed, range, price);
			break;
		case "4": case "fc": case "FC": case "g": case "G":
			newJet = new Gunship(model, speed, range, price);
			break;
		default:
			System.out.println("\n Invalid jet type " + type);
			break;
		}
		if (newJet != null) {
			airField.addJet(newJet);
			System.out.println("Jet added.");
		}
		
	}
	
	private void removeJet() {
		List<Jet> jets = airField.getAllJets();
		for (int i = 0; i < jets.size(); i++) {
			System.out.println( (1+i) + ") " + jets.get(i).getModel());
		}
		System.out.println("\nWhich jet are you removing? ");
		int choice = scanner.nextInt();
		scanner.nextLine(); //clear input buffer
		if (airField.removeJet(choice - 1)) {
			System.out.println("Jet removed.");
		}
		
	}
}

