package com.uncc.gameday.registration;

import java.util.List;

import retrofit.http.*;

public interface GamedayService {
	
	@GET("/lots/")
	List<ParkingLot> listLots();
	
	@POST("/rating/")
	void rateLot(@Body ParkingRating rating, @Body ParkingChoices parking_lot);

}
