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

// TODO: Auto-generated Javadoc
/**
 * The Interface GamedayService.
 */
public interface GamedayService {
	
	/**
	 * List lots.
	 *
	 * @return the list
	 */
	@GET("/lots/")
	List<ParkingLot> listLots();
	
	/**
	 * List lot.
	 *
	 * @param lot the lot
	 * @return the parking lot
	 */
	@GET("/lots/{lot}/")
	ParkingLot listLot(@Path("lot") String lot);
	
	/**
	 * Rate lot.
	 *
	 * @param p the p
	 * @param lot the lot
	 */
	@POST("/lots/rate/")
	void rateLot(@Body ParkingRating p, Callback<ParkingLot> lot);
	
	/**
	 * List lot location.
	 *
	 * @param lot the lot
	 * @return the parking coordinate
	 */
	@GET("/lots/{lot}/")
	ParkingCoordinate listLotLocation(@Path("lot") String lot);
	
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GET("/register/{id}/")
	Attendee getUser(@Path("id") int id);
	
	/**
	 * Gets the user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the user
	 */
	@GET("/register/{fname}/{lname}/")
	Attendee getUser(@Path("fname") String firstName, @Path("lname") String lastName);
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GET("/register/")
	List<Attendee> getAllUsers();
	
	/**
	 * Register user.
	 *
	 * @param a the a
	 * @param attendee the attendee
	 */
	@POST("/register/")
	void registerUser(@Body Attendee a, Callback<Attendee> attendee);

}
