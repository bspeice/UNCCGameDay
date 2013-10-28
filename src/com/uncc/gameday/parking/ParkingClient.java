package com.uncc.gameday.parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<ParkingLot, ParkingLocation> listLotLocation(ParkingLot p){
		HashMap<ParkingLot, ParkingLocation> mMap = new HashMap<ParkingLot, ParkingLocation>();
		mMap.put(p, gds.listLotLocation(p.getLocation().getValue()));
		return mMap;
	}
	
	public Map<ParkingLot, ParkingLocation> listLotLocation(ParkingChoices c) {
		HashMap<ParkingLot, ParkingLocation> mMap = new HashMap<ParkingLot, ParkingLocation>();
		ParkingLot mParkingLot = new ParkingLot();
		mParkingLot.setLocation(c);
		mMap.put(mParkingLot, gds.listLotLocation(c.getValue()));
		return mMap;
	}
}
