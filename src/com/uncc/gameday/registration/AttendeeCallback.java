package com.uncc.gameday.registration;

import android.util.Log;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AttendeeCallback implements Callback<Attendee> {

	@Override
	public void failure(RetrofitError e) {
		Log.w("AttendeeCallback", e.getMessage());		
	}

	@Override
	public void success(Attendee a, Response r) {
		return;
	}

}
