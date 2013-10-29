package com.uncc.gameday.parking;

public enum ParkingChoice {
	GREEN ("GREEN"),
	BLACK ("BLACK"),
	RED ("RED"),
	BLUE ("BLUE"),
	SILVER ("SILVER"),
	ORANGE ("ORANGE"),
	YELLOW ("YELLOW"),
	PURPLE ("PURPLE"),
	PINK ("PINK"),
	WHITE ("WHITE"),
	GOLD ("GOLD");
	
	String choice;
	ParkingChoice(String choice) { this.choice = choice; }
	public String getValue() { return choice; }
}