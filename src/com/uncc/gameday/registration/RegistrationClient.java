package com.uncc.gameday.registration;

import java.util.List;

import com.uncc.gameday.GameDay;
import com.uncc.gameday.R;

/* Client used for interfacing with the server API */

public class RegistrationClient {
	
	private String serverName = GameDay.getAppContext().getString(R.string.server_hostname);
	
	public void registerAttendee(Attendee a) {
		
	}
	
	public List<Attendee> listAttendeeNames() {
		// List all attendees to the game
		
		return null;
	}
	
	public List<Attendee> listAttendeeNames(int begin, int end) {
		// List attendees to the game supporting pagination
		
		return null;
	}
	
	public Attendee getAttendee(int id) {
		// Get the full information for a single attendee
		
		return null;
	}

}
