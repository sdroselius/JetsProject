package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {
		super();
	}

	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " tally-ho!  Pew pew pew pew");
	}
	
}
