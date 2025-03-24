package com.skilldistillery.jets.entities;

public class Gunship extends Jet implements CargoCarrier, CombatReady {

	public Gunship(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(getModel()+" gunship unloading huge amounts of ammunition");
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel()+" gunshipe loading huge amounts of ammunition");

	}

}
