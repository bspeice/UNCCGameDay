package com.uncc.gameday.parking;

import android.util.Log;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Utility class used by Retrofit for implementing a callback on POST.
 * Why they can't use a synchronous POST is beyond me.
 * This class is likely un-needed, but allows for easy change in the future
 * if needed.
 */
public class ParkingLotCallback implements Callback<ParkingLot> {

	/* (non-Javadoc)
	 * @see retrofit.Callback#failure(retrofit.RetrofitError)
	 */
	@Override
	public void failure(RetrofitError e) {
		Log.w("ParkingLotCallback", e.getMessage());
	}

	/* (non-Javadoc)
	 * @see retrofit.Callback#success(java.lang.Object, retrofit.client.Response)
	 */
	@Override
	public void success(ParkingLot p, Response r) {
		return;
	}

}
