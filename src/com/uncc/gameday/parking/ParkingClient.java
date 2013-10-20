package com.uncc.gameday.parking;

import java.util.List;

import retrofit.RestAdapter;
import android.content.Context;

import com.uncc.gameday.R;
import com.uncc.gameday.rest.GamedayService;

public class ParkingClient {

	private GamedayService gds;
	
	public ParkingClient(Context c) {
		RestAdapter ra = new RestAdapter.Builder()
			.setServer("http://" + c.getString(R.string.server_hostname))
			.build();
		gds = ra.create(GamedayService.class);
	}
	
	public List<ParkingLot> listLots() {
		return gds.listLots();
	}
	
	public ParkingLot listLot(ParkingChoices choice) {
		return gds.listLot(choice.getValue());
	}
	
	public ParkingLot listLot(ParkingLot lot) {
		return gds.listLot(lot.getLocation().getValue());
	}
	
	public void rateLot(RatingChoices rating, ParkingChoices parkingLot) {
		ParkingRating pRating = new ParkingRating();
		pRating.setParkingLot(parkingLot);
		pRating.setRating(rating);
		gds.rateLot(pRating, new ParkingLotCallback());
	}
	
	public void rateLot(ParkingRating rating) {
		gds.rateLot(rating, new ParkingLotCallback());
	}
}
