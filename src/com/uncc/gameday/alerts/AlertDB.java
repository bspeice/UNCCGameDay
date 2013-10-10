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

	public void insertAlerts(List<Alert> alarmDates) {
		// Add multiple new dates to the database
	}
	
	public void deleteAlert(Alert alert) {
		// Remove a date from the database
	}
	
	public void deleteAlerts(List<Alert> alerts) {
		// Remove multiple dates from the database
	}
	
	public List<Alert> fetchUnread() {
		// Fetch all unread alerts
		return null;
	}
}
