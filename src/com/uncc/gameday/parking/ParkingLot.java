package com.uncc.gameday.parking;

/**
 * The Class ParkingLot.
 * Basic POJO used for communicating information about each Parking lot
 * between the Gameday app and server-side implementation
 */
public class ParkingLot {
	
	/** The location. */
	private ParkingChoice location;
	
	/** The filled_pct. */
	private int filled_pct;
	
	/** The coordinate. */
	private ParkingCoordinate coordinate;
	
	/**
	 * Gets the filled pct.
	 *
	 * @return the filled pct
	 */
	public int getFilledPct() {
		return filled_pct;
	}
	
	/**
	 * Sets the filled pct.
	 *
	 * @param filled_pct the new filled pct
	 */
	public void setFilledPct(int filled_pct) {
		this.filled_pct = filled_pct;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public ParkingChoice getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(ParkingChoice location) {
		this.location = location;
	}
	
	/**
	 * Gets the coordinate.
	 *
	 * @return the coordinate
	 */
	public ParkingCoordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * Sets the coordinate.
	 *
	 * @param coordinate the new coordinate
	 */
	public void setCoordinate(ParkingCoordinate coordinate) {
		this.coordinate = coordinate;
	}

}
