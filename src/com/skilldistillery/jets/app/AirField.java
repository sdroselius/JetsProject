package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.BusinessJet;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Gunship;
import com.skilldistillery.jets.entities.Jet;

public class AirField {

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		loadJetsFromFile("jetData.txt");
	}

	public void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split("[|]");
				String type = fields[0];
				String model = fields[1];
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				Jet j;
				switch (type) {
				case "B":
					j = new BusinessJet(model, speed, range, price);
					fleet.add(j);
					break;
				case "F":
					j = new FighterJet(model, speed, range, price);
					fleet.add(j);
					break;
				case "C":
					j = new CargoJet(model, speed, range, price);
					fleet.add(j);
					break;
				case "FC":
					j = new Gunship(model, speed, range, price);
					fleet.add(j);
					break;
				default:
					System.err.println("Invalid Jet type " + fields[0]);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void displayFleet() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}

	public List<Jet> getAllJets() {
		return new ArrayList<>(fleet);
	}

	public void flyAllJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public Jet getFastestJet() {
		Jet fastest = null;
		if (fleet != null && fleet.size() > 0) {
			fastest = fleet.get(0);
			for (Jet jet : fleet) {
				if (jet.getSpeed() > fastest.getSpeed()) {
					fastest = jet;
				}
			}
		}
		return fastest;
	}

	public Jet getLongestRangeJet() {
		Jet longestRange = null;
		if (fleet != null && fleet.size() > 0) {
			longestRange = fleet.get(0);
			for (Jet jet : fleet) {
				if (jet.getSpeed() > longestRange.getSpeed()) {
					longestRange = jet;
				}
			}
		}
		return longestRange;
	}

	public void sortyFighters() {
		System.out.println("\n--- Sortying fighters");
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				((CombatReady)jet).fight();
			}
		}
	}

	public void loadCargoJets() {
		System.out.println("\n--- Loading freighters");
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier)jet).loadCargo();
			}
		}
	}

	public void addJet(Jet newJet) {
		fleet.add(newJet);
	}

	public boolean removeJet(int index) {
		boolean removed = false;
		if (fleet != null && index >= 0 && index < fleet.size()) {
			fleet.remove(index);
			removed = true;
		}
		return removed;

	}

}
