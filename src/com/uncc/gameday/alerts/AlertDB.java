package com.uncc.gameday.alerts;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/* Responsible for handling persistence/fetching of alerts */

/**
 * The Class AlertDB.
 */
public class AlertDB {

	/**
	 * Persist.
	 *
	 * @param a the a
	 */
	public void persist(Alert a) {
		
	}
	
	/**
	 * Persist multiple.
	 *
	 * @param alerts the alerts
	 */
	public void persistMultiple(List<Alert> alerts) {
		
	}
	
	/**
	 * Fetch.
	 *
	 * @param d the d
	 * @return the alert
	 */
	public Alert fetch(Date d) {
		
		return null;
	}
	
	/**
	 * Fetch multiple.
	 *
	 * @param dates the dates
	 * @return the list
	 */
	public List<Alert> fetchMultiple(List<Date> dates) {
		
		return null;
	}
	
	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	public List<Alert> fetchAll() {
		
		return null;
	}
	
	/**
	 * Fetch unread.
	 *
	 * @return the list
	 */
	public List<Alert> fetchUnread() {
		return null;
	}
}
