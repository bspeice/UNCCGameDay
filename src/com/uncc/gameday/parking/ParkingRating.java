package com.uncc.gameday.parking;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingRating.
 */
public class ParkingRating  {
	
	/** The parking_lot. */
	private ParkingChoice parking_lot;
	
	/** The rating. */
	private RatingChoices rating;
	
	/**
	 * Gets the parking lot.
	 *
	 * @return the parking lot
	 */
	public ParkingChoice getParkingLot() {
		return parking_lot;
	}
	
	/**
	 * Sets the parking lot.
	 *
	 * @param parking_lot the new parking lot
	 */
	public void setParkingLot(ParkingChoice parking_lot) {
		this.parking_lot = parking_lot;
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public RatingChoices getRating() {
		return rating;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(RatingChoices rating) {
		this.rating = rating;
	}
}
