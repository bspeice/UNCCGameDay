package com.uncc.gameday.registration;

public class ParkingRating  {
	private ParkingChoices parking_lot;
	private RatingChoices rating;
	
	public ParkingChoices getParkingLot() {
		return parking_lot;
	}
	public void setParkingLot(ParkingChoices parking_lot) {
		this.parking_lot = parking_lot;
	}
	public RatingChoices getRating() {
		return rating;
	}
	public void setRating(RatingChoices rating) {
		this.rating = rating;
	}
}
