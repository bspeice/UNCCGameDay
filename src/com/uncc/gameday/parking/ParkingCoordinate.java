package com.uncc.gameday.parking;

import android.content.Intent;
import android.net.Uri;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingCoordinate.
 */
public class ParkingCoordinate {
	
	/** The latitude. */
	private double latitude;
	
	/** The longitude. */
	private double longitude;
	
	/** The label. */
	private String label;
	
	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Gets the navigation uri.
	 *
	 * @return the navigation uri
	 */
	public Uri getNavigationURI() {
		// URI used to construct an intent for navigation
		return Uri.parse("google.navigation:q=" + this.getLatitude() + "," + this.getLongitude());
	}
	
	/**
	 * Gets the navigation intent.
	 *
	 * @return the navigation intent
	 */
	public Intent getNavigationIntent() {
		// Intent used to do navigation
		return new Intent(Intent.ACTION_VIEW, this.getNavigationURI());
	}
	
	/**
	 * Instantiates a new parking coordinate.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param label the label
	 */
	public ParkingCoordinate(double latitude, double longitude, String label) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.label = label;
	}
	
}
