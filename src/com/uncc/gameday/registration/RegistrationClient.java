package com.uncc.gameday.registration;

import java.util.List;

import retrofit.RestAdapter;
import android.content.Context;

import com.uncc.gameday.R;
import com.uncc.gameday.rest.GamedayService;

public class RegistrationClient {
	
	private GamedayService gds;
	
	public RegistrationClient(Context c) {
		RestAdapter ra = new RestAdapter.Builder()
			.setServer("http://" + c.getString(R.string.server_hostname))
			.build();
		gds = ra.create(GamedayService.class);
	}
	
	public void registerAttendee(Attendee a) {
		gds.registerUser(a, new AttendeeCallback());
	}
	
	public Attendee listAttendee(int id) {
		return gds.getUser(id);
	}
	
	public Attendee listAttendee(Attendee a) {
		return gds.getUser(a.getFirstName(), a.getLastName());
	}
	
	public List<Attendee> listAttendees() {
		return gds.getAllUsers();
	}
}
