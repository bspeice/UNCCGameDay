package com.uncc.gameday.parking;

import android.content.Intent;
import android.net.Uri;

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
	
	public Uri getNavigationURI() {
		// URI used to construct an intent for navigation
		return Uri.parse("google.navigation:q=" + this.getLatitude() + "," + this.getLongitude());
	}
	
	public Intent getNavigationIntent() {
		// Intent used to do navigation
		return new Intent(Intent.ACTION_VIEW, this.getNavigationURI());
	}
	
	public ParkingCoordinate(double latitude, double longitude, String label) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.label = label;
	}
	
}
