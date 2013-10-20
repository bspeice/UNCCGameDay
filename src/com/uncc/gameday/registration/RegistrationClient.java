package com.uncc.gameday.registration;

import java.util.List;

import retrofit.RestAdapter;
import android.content.Context;

import com.uncc.gameday.R;
import com.uncc.gameday.parking.ParkingChoices;
import com.uncc.gameday.parking.ParkingLot;
import com.uncc.gameday.parking.ParkingLotCallback;
import com.uncc.gameday.parking.ParkingRating;
import com.uncc.gameday.parking.RatingChoices;
import com.uncc.gameday.rest.GamedayService;

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
