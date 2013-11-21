package com.uncc.gameday.alerts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* Responsible for handling persistence/fetching of alerts */

public class AlertDB extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "AlertDataBase";
	private static final String TABLE_ALERTS = "alerts";

	private static final String KEY_ALARM_DATE = "alarm_date";
	private static final String KEY_MESSAGE = "message";
	private static final String KEY_SHOWN = "shown";
	private static final String KEY_TYPE = "type";
	

	public AlertDB(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ALERTS_TABLE = "CREATE TABLE " + TABLE_ALERTS + "("
				+ KEY_MESSAGE + " STRING PRIMARY KEY," + KEY_ALARM_DATE + " LONG,"
				+ KEY_SHOWN + " INT," + KEY_TYPE + " STRING" + ")";
		db.execSQL(CREATE_ALERTS_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//drop older table if it exists
		db.execSQL("DROP OLDER TABLE " + TABLE_ALERTS);
		
		//recreate tables
		onCreate(db);
		
	}

	//persist alert into Database
	public void persist(Alert a) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_MESSAGE, a.getMessage());
		
		long dateValue = a.getAlarmDate().getTime();
		values.put(KEY_ALARM_DATE, dateValue);
		values.put(KEY_SHOWN, a.isShown());
		values.put(KEY_TYPE, a.getType());

		db.insert(TABLE_ALERTS, null, values);
		db.close();
	}
	
	//persist list of alerts by looping through list
	//and calling persist
	public void persistMultiple(List<Alert> alerts) {
    	
		for(int i = 0; i < alerts.size(); i++)
    	{
    		persist(alerts.get(i));
    	}
		
	}
	
	public Alert fetch(Date d) {
		
		return null;
	}
	
	public List<Alert> fetchMultiple(List<Date> dates) {
		
		return null;
	}
	
	
	//get all alerts from Database
	//regardless of type, or if it has been shown
	//update each alert in DB as being shown
	public List<Alert> fetchAll() {
		
		List<Alert> alertList = new ArrayList<Alert>();
		
		String selectQuery = "SELECT  * FROM " + TABLE_ALERTS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		//for each alert in database
		//add it to alert list to be shown
		//and modify it in DB to be classified as shown
		if (cursor.moveToFirst())
		{
			do
			{
				Alert alert = new Alert();
				alert.setMessage(cursor.getString(0));
				alert.setAlarmDate(new Date(cursor.getLong(1)));
				alert.setShown(cursor.getInt(2));
				updateAlert(alert);
				
				alertList.add(alert);
			} while (cursor.moveToNext());
			
		}	
		db.close();
		return alertList;
	}
	
	//fetch just unread alerts from database
	public List<Alert> fetchUnread() {
		
		List<Alert> alertList = new ArrayList<Alert>();
		String selectQuery = "SELECT  * FROM " + TABLE_ALERTS;
	
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		//for each alert in database
		//given it is classified as unread
		//add it to alert list to be shown
		//and modify it in DB to be classified as shown
		if (cursor.moveToFirst())
		{
			do
			{
				Alert alert = new Alert();
				if(cursor.getInt(2) == 0)
				{
					alert.setMessage(cursor.getString(0));
					alert.setAlarmDate(new Date(cursor.getLong(1)));
					alert.setShown(cursor.getInt(2));
					
					updateAlert(alert);
					alertList.add(alert);	
				}
			} while (cursor.moveToNext());
			
		}	
		db.close();
		return alertList;
	}

	//update alert in DB to be classified as shown
	private int updateAlert(Alert alert) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		long dateValue = alert.getAlarmDate().getTime();
		values.put(KEY_ALARM_DATE, dateValue);
		values.put(KEY_SHOWN, 1);
		
		return db.update(TABLE_ALERTS, values, KEY_MESSAGE + " = ?",
				new String[] { String.valueOf(alert.getMessage()) });
		
	}

}


