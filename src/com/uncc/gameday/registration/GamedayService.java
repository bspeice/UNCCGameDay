package com.uncc.gameday.registration;

import java.util.List;

import retrofit.Callback;
import retrofit.http.*;

public interface GamedayService {
	
	@GET("/lots/")
	List<ParkingLot> listLots();
	
	@GET("/lots/{lot}/")
	ParkingLot listLot(@Path("lot") String lot);
	
	@POST("/rate/")
	void rateLot(@Body ParkingRating p, Callback<ParkingLot> lot);
	
	@GET("/register/{id}/")
	Attendee getUser(@Path("id") int id);
	
	@GET("/register/{fname}/{lname}/")
	Attendee getUser(@Path("fname") String firstName, @Path("lname") String lastName);
	
	@GET("/register/")
	List<Attendee> getAllUsers();
	
	@POST("/register/")
	void registerUser(@Body Attendee a, Callback<Attendee> attendee);

}
