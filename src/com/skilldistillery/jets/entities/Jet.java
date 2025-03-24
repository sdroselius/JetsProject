package com.skilldistillery.jets.entities;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;
	
	public void fly() {
		System.out.println("I am a " + model + " flying at " + speed + " mph; "
				+ "My range is " + range + " miles");
		int flightTimeHours = (int)(range / speed);
		int flightTimeMinutes = (int)(((range/speed) - (int)(range/speed) )* 60);
		System.out.println("I can fly " + flightTimeHours + " hours " + " and " + flightTimeMinutes + " minutes");
	}
	
	public double getSpeedInMach() {
		return speed * 0.00130332;
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=").append(model).append(", speed=").append(speed).append(", range=").append(range)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}

}
