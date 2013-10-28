package com.uncc.gameday.rest;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import com.uncc.gameday.parking.ParkingCoordinate;
import com.uncc.gameday.parking.ParkingLot;
import com.uncc.gameday.parking.ParkingRating;
import com.uncc.gameday.registration.Attendee;

public interface GamedayService {
	
	@GET("/lots/")
	List<ParkingLot> listLots();
	
	@GET("/lots/{lot}/")
	ParkingLot listLot(@Path("lot") String lot);
	
	@POST("/lots/rate/")
	void rateLot(@Body ParkingRating p, Callback<ParkingLot> lot);
	
	@GET("/lots/{lot}/")
	ParkingCoordinate listLotLocation(@Path("lot") String lot);
	
	@GET("/register/{id}/")
	Attendee getUser(@Path("id") int id);
	
	@GET("/register/{fname}/{lname}/")
	Attendee getUser(@Path("fname") String firstName, @Path("lname") String lastName);
	
	@GET("/register/")
	List<Attendee> getAllUsers();
	
	@POST("/register/")
	void registerUser(@Body Attendee a, Callback<Attendee> attendee);

}
