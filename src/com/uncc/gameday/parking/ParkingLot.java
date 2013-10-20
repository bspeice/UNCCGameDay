package com.uncc.gameday.parking;

public class ParkingLot {
	
	private ParkingChoices location;
	private int filled_pct;
	
	public int getFilledPct() {
		return filled_pct;
	}
	public void setFilledPct(int filled_pct) {
		this.filled_pct = filled_pct;
	}
	public ParkingChoices getLocation() {
		return location;
	}
	public void setLocation(ParkingChoices location) {
		this.location = location;
	}

}
