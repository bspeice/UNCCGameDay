package com.uncc.gameday.alerts;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

import com.uncc.gameday.GameDay;
import com.uncc.gameday.R;

public class AlertDB {
	
	private SQLiteDatabase dbHandle;
	private SQLiteDatabase.CursorFactory factory;
	
	public AlertDB() {
		this.dbHandle = SQLiteDatabase.openOrCreateDatabase(GameDay.getAppContext().getString(R.string.db_path), factory);
	}
	
	public void insertAlert(Alert alert) {
		// Add a new date to the database
	}
	
	public void insertAlertRead(Alert alert) {
		// Add a new date to the database that should not be alerted.
		// This way, you can display it in the recent alerts list, but
		// not show it to the user.
	}
	
	public void insertAlerts(List<Alert> alarmDates) {
		// Add multiple new dates to the database
	}
	
	public void insertAlertsRead(List<Alert> alarmDates) {
		// Add multiple new dates to the database, and mark them as read.
	}
	
	public List<Alert> fetchUnreadAlerts() {
		// Get a list of all currently unread alerts
		
		return null;
	}
	
}
