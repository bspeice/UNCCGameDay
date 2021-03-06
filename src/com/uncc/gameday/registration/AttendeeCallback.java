package com.uncc.gameday.registration;

import android.util.Log;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class AttendeeCallback.
 * Used to implement a POST callback for Retrofit. Same deal as the ParkingCallback,
 * not sure it's needed, but makes our lives easy if we need to change it later.
 */
public class AttendeeCallback implements Callback<Attendee> {

	/* (non-Javadoc)
	 * @see retrofit.Callback#failure(retrofit.RetrofitError)
	 */
	@Override
	public void failure(RetrofitError e) {
		Log.w("AttendeeCallback", e.getMessage());		
	}

	/* (non-Javadoc)
	 * @see retrofit.Callback#success(java.lang.Object, retrofit.client.Response)
	 */
	@Override
	public void success(Attendee a, Response r) {
		return;
	}

}
