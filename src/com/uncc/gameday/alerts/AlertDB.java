package com.uncc.gameday.alerts;

import java.util.Date;
import java.util.List;

/* Responsible for handling persistence/fetching of alerts */

public class AlertDB {

	public void persist(Alert a) {
		
	}
	
	public void persistMultiple(List<Alert> alerts) {
		
	}
	
	public Alert fetch(Date d) {
		
		return null;
	}
	
	public List<Alert> fetchMultiple(List<Date> dates) {
		
		return null;
	}
	
	public List<Alert> fetchAll() {
		
		return null;
	}
	
	public List<Alert> fetchUnread() {
		return null;
	}
}
