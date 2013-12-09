package com.uncc.gameday.parking;

import java.util.List;

import retrofit.RestAdapter;
import android.content.Context;

import com.uncc.gameday.R;
import com.uncc.gameday.rest.GamedayService;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingClient.
 */
public class ParkingClient {

	/** The GamedayService reference */
	private GamedayService gds;
	
	/**
	 * Instantiates a new parking client.
	 *
	 * @param c - The context used to access the Resource file
	 */
	public ParkingClient(Context c) {
		RestAdapter ra = new RestAdapter.Builder()
			.setServer("http://" + c.getString(R.string.server_hostname))
			.build();
		gds = ra.create(GamedayService.class);
	}
	
	/**
	 * List all parking lots
	 *
	 * @return the list
	 */
	public List<ParkingLot> listLots() {
		return gds.listLots();
	}
	
	/**
	 * List lot.
	 *
	 * @param choice the choice
	 * @return the parking lot
	 */
	public ParkingLot listLot(ParkingChoice choice) {
		return gds.listLot(choice.getValue());
	}
	
	/**
	 * List lot.
	 *
	 * @param lot the lot
	 * @return the parking lot
	 */
	public ParkingLot listLot(ParkingLot lot) {
		return gds.listLot(lot.getLocation().getValue());
	}
	
	/**
	 * Rate lot.
	 *
	 * @param rating the rating
	 * @param parkingLot the parking lot
	 */
	public void rateLot(RatingChoices rating, ParkingChoice parkingLot) {
		ParkingRating pRating = new ParkingRating();
		pRating.setParkingLot(parkingLot);
		pRating.setRating(rating);
		gds.rateLot(pRating, new ParkingLotCallback());
	}
	
	/**
	 * Rate lot.
	 *
	 * @param rating the rating
	 */
	public void rateLot(ParkingRating rating) {
		gds.rateLot(rating, new ParkingLotCallback());
	}
	
}
