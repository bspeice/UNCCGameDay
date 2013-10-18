package com.uncc.gameday.registration;

import java.util.List;

import com.uncc.gameday.R;

import android.content.Context;
import android.util.Log;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class RegistrationClient {
	
	private GamedayService gds;
	
	public RegistrationClient(Context c) {
		RestAdapter ra = new RestAdapter.Builder()
			.setServer("http://" + c.getString(R.string.server_hostname))
			.build();
		gds = ra.create(GamedayService.class);
	}
	
	public List<ParkingLot> listLots() {
		return gds.listLots();
	}
	
	public void rateLot(ParkingRating rating, ParkingChoices parkingLot) {
		gds.rateLot(rating, parkingLot);
	}

}
