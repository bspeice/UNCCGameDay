package com.uncc.gameday.registration;

import java.util.List;

import retrofit.RestAdapter;
import android.content.Context;

import com.uncc.gameday.R;
import com.uncc.gameday.rest.GamedayService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationClient.
 * Client used for wrapping around the service provided by Retrofit. This way,
 * all the lower-level details are handled, and we can overload some behavior
 * to enable working with different classes.
 */
public class RegistrationClient {
	
	/** The gds. */
	private GamedayService gds;
	
	/**
	 * Instantiates a new registration client.
	 *
	 * @param c the c
	 */
	public RegistrationClient(Context c) {
		RestAdapter ra = new RestAdapter.Builder()
			.setServer("http://" + c.getString(R.string.server_hostname))
			.build();
		gds = ra.create(GamedayService.class);
	}
	
	/**
	 * Register attendee.
	 *
	 * @param a the a
	 */
	public void registerAttendee(Attendee a) {
		gds.registerUser(a, new AttendeeCallback());
	}
	
	/**
	 * List attendee.
	 *
	 * @param id the id
	 * @return the attendee
	 */
	public Attendee listAttendee(int id) {
		return gds.getUser(id);
	}
	
	/**
	 * List attendee.
	 *
	 * @param a the a
	 * @return the attendee
	 */
	public Attendee listAttendee(Attendee a) {
		return gds.getUser(a.getFirstName(), a.getLastName());
	}
	
	/**
	 * List attendees.
	 *
	 * @return the list
	 */
	public List<Attendee> listAttendees() {
		return gds.getAllUsers();
	}
}
