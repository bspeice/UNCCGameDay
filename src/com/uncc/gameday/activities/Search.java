package com.uncc.gameday.activities;

import java.util.List;

import retrofit.RetrofitError;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.uncc.gameday.R;
import com.uncc.gameday.registration.Attendee;
import com.uncc.gameday.registration.RegistrationClient;

public class Search extends MenuActivity {
	
	List<Attendee> rsvpList;
	boolean listFetched = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_rsvp);
		new fetchAttendeesThread(this).start();
	}
	
	private class fetchAttendeesThread extends Thread {
		Context c;
		public fetchAttendeesThread(Context c) {
			this.c = c;
		}
		
		public void run() {
			try {
				RegistrationClient client = new RegistrationClient(this.c);
				rsvpList = client.listAttendees();
				listFetched = true;
			} catch (RetrofitError e) {
				Toast.makeText(c, R.string.internet_down_error, Toast.LENGTH_SHORT).show();
				Log.e("Search", e.getLocalizedMessage());
			}
		}
	}

}
