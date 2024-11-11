package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class AirField {
	
	private List<Jet> fleet = new ArrayList<>();
	// NO other fields
	
	public AirField() {
		loadJetsFromFile("jets.txt");
	}
	
	private void loadJetsFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				String jetType = fields[0]; //cargo fighter etc.
				String model = fields[1];
				int speed = Integer.parseInt(fields[2]);
				int range = Integer.parseInt(fields[3]);
				double price = Double.parseDouble(fields[4]);
				// Use jetType to determine witch subclass of Jet to construct
				Jet newJet = null;
				switch(jetType) {
					case "cargo":
						newJet = new CargoJet(model, speed, range, price);
						fleet.add(newJet);
						break;
					case "fighter":
						newJet = new FighterJet(model, speed, range, price);
						fleet.add(newJet);
						break;
					default:
						newJet = new PassengerJet(model, speed, range, price);
						fleet.add(newJet);
						break;
				}
				System.out.println("Added Jet: " + newJet);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listAllJets() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}
	
	public void flyAllJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}
	
	public Jet getFastestJet() {
		Jet fastest = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		return fastest;
	}
	
	public Jet getLongestRange() {
		Jet longestRange = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		return longestRange;
	}
	
	public void loadCargo() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void dogfight() {
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}
	
}
