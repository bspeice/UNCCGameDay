package com.uncc.gameday.parking;

import android.util.Log;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ParkingLotCallback implements Callback<ParkingLot> {

	@Override
	public void failure(RetrofitError e) {
		Log.w("ParkingLotCallback", e.getMessage());
	}

	@Override
	public void success(ParkingLot p, Response r) {
		return;
	}

}
