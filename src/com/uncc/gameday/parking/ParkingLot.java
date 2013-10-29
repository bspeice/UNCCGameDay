package com.uncc.gameday.parking;

public class ParkingLot {
	
	private ParkingChoice location;
	private int filled_pct;
	private ParkingCoordinate coordinate;
	
	public int getFilledPct() {
		return filled_pct;
	}
	public void setFilledPct(int filled_pct) {
		this.filled_pct = filled_pct;
	}
	public ParkingChoice getLocation() {
		return location;
	}
	public void setLocation(ParkingChoice location) {
		this.location = location;
	}
	public ParkingCoordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(ParkingCoordinate coordinate) {
		this.coordinate = coordinate;
	}

}
