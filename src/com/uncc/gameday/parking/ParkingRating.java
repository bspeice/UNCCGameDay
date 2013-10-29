package com.uncc.gameday.parking;

public class ParkingRating  {
	private ParkingChoice parking_lot;
	private RatingChoices rating;
	
	public ParkingChoice getParkingLot() {
		return parking_lot;
	}
	public void setParkingLot(ParkingChoice parking_lot) {
		this.parking_lot = parking_lot;
	}
	public RatingChoices getRating() {
		return rating;
	}
	public void setRating(RatingChoices rating) {
		this.rating = rating;
	}
}
