package com.uncc.gameday.registration;

import java.util.List;

import retrofit.http.*;

public interface GamedayService {
	
	@GET("/lots/")
	List<ParkingLot> listLots();
	
	@GET("/lots/{lot}/")
	ParkingLot listLot(@Path("lot") String lot);
	
	@POST("/rating/")
	void rateLot(@Body RatingChoices rating, @Body ParkingChoices parking_lot);

}
