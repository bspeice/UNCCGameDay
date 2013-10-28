package com.uncc.gameday.parking;

public class ParkingCoordinate {
	private double latitude;
	private double longitude;
	private String label;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public ParkingCoordinate(double latitude, double longitude, String label) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.label = label;
	}
	
}
