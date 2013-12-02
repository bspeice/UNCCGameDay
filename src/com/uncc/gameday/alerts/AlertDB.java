package com.uncc.gameday.alerts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* Responsible for handling persistence/fetching of alerts */

/**
 * The Class AlertDB.
 */
public class AlertDB extends SQLiteOpenHelper {
        
        /** The Constant DATABASE_VERSION. */
        private static final int DATABASE_VERSION = 1;
        
        /** The Constant DATABASE_NAME. */
        private static final String DATABASE_NAME = "AlertDataBase";
        
        /** The Constant TABLE_ALERTS. */
        private static final String TABLE_ALERTS = "alerts";

        /** The Constant KEY_ALARM_DATE. */
        private static final String KEY_ALARM_DATE = "alarm_date";
        
        /** The Constant KEY_MESSAGE. */
        private static final String KEY_MESSAGE = "message";
        
        /** The Constant KEY_SHOWN. */
        private static final String KEY_SHOWN = "shown";
        
        /** The Constant KEY_TYPE. */
        private static final String KEY_TYPE = "type";
        

        /**
         * Instantiates our wrapper around the SQLiteOpenHelper
         *
         * @param context - The context to open the database in
         */
        public AlertDB(Context context){
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        
        /**
         * Create the initial Database
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
                String CREATE_ALERTS_TABLE = "CREATE TABLE " + TABLE_ALERTS + "("
                                + KEY_MESSAGE + " STRING PRIMARY KEY," + KEY_ALARM_DATE + " LONG,"
                                + KEY_SHOWN + " INT," + KEY_TYPE + " STRING" + ")";
                db.execSQL(CREATE_ALERTS_TABLE);
        }
        
        /**
         * Upgrade the database on application update
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                //drop older table if it exists
                db.execSQL("DROP OLDER TABLE " + TABLE_ALERTS);
                
                //recreate tables
                onCreate(db);
                
        }

        /**
         * Persist an alert into the database
         *
         * @param a - The Alert to persist
         */
        public void persist(Alert a) {
                
                SQLiteDatabase db = this.getWritableDatabase();
                
                ContentValues values = new ContentValues();
                values.put(KEY_MESSAGE, a.getMessage());
                
           
                values.put(KEY_ALARM_DATE, a.getAlarmDate());
                values.put(KEY_SHOWN, a.isShown());
                values.put(KEY_TYPE, a.getType());

                db.insert(TABLE_ALERTS, null, values);
                db.close();
        }
	
        /**
         * Persist a list of alerts into the database -
         * helper method for easy iteration
         *
         * @param alerts - The alerts to store
         */
        public void persistMultiple(List<Alert> alerts) {
            
                for(int i = 0; i < alerts.size(); i++)
            {
                    persist(alerts.get(i));
            }
                
        }
        
        
        /**
         * Fetch an alert by date
         * TODO: Unused. Remove?
         *
         * @param d - The date to fetch an alert from
         * @return the Alert
         */
        public Alert fetch(Date d) {
                
                return null;
        }
        
        /**
         * Fetch multiple alerts from the Database
         * TODO: Unused. Remove?
         *
         * @param dates the dates to fetch alerts from
         * @return the list
         */
        public List<Alert> fetchMultiple(List<Date> dates) {
                
                return null;
        }
        
        /**
         * Delete an alert from the Database whenever the Alert message matches
         *
         * @param alert the alert
         */
        public void deleteAlert(Alert alert) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.delete(TABLE_ALERTS, KEY_MESSAGE + " = ?", 
                                new String[] { String.valueOf(alert.getMessage()) });
                db.close();
                
                }

        /**
         * Fetch all alerts from the Database
         *
         * @return the list
         */
		public List<Alert> fetchAll() {
		
        	List<Alert> alertList = new ArrayList<Alert>();
		
        	String selectQuery = "SELECT  * FROM " + TABLE_ALERTS;
		
        	SQLiteDatabase db = this.getWritableDatabase();
        	Cursor cursor = db.rawQuery(selectQuery, null);
		
        	//for each alert in database
        	//add it to alert list to be shown
        	//and modify it in DB to be classified as shown
        	int i = 0;
        	if (cursor.moveToFirst())
        		{
        		
        		GregorianCalendar todayDate = new GregorianCalendar();
        		long currentDate = todayDate.getTimeInMillis();
        		
        		do
        		{
        			if(currentDate >= cursor.getLong(1))
        			{
        				Alert alert = new Alert();
        				alert.setMessage(cursor.getString(0));
        				alert.setAlarmDate(cursor.getLong(1));
        				alert.setShown(cursor.getInt(2));
				
        				alertList.add(alert);
        				i++;
        			}
        		} while (cursor.moveToNext() && i < 10);
			
        		}	
        	db.close();	
        	
        	//sorts alerts by Date
        	Collections.sort(alertList, new Comparator<Alert>() {
        		@Override
        		public int compare(Alert a1, Alert a2) {
				
        			String compareDate = Long.toString(a1.getAlarmDate());
        			String thisDate = Long.toString(a2.getAlarmDate());
        			return thisDate.compareTo(compareDate);
        		}
			
        	});
        	return alertList;
	}
	
        /**
         * Fetch unread alerts from the database, and mark them as read
         *
         * @return the list
         */
        public List<Alert> fetchUnread() {
		
        	List<Alert> alertList = new ArrayList<Alert>();
        	String selectQuery = "SELECT  * FROM " + TABLE_ALERTS;
	
        	SQLiteDatabase db = this.getWritableDatabase();
        	Cursor cursor = db.rawQuery(selectQuery, null);
		
        	//for each alert in database
        	//given it is classified as unread
        	//add it to alert list to be shown
        	//and modify it in DB to be classified as shown
        	int i = 0;
        	if (cursor.moveToFirst())
        	{
        		
        		GregorianCalendar todayDate = new GregorianCalendar();
        		long currentDate = todayDate.getTimeInMillis();
        		do
        		{
        			if(cursor.getInt(2) == 0 && currentDate >= cursor.getLong(1))
        			{
        				Alert alert = new Alert();
        				alert.setMessage(cursor.getString(0));
        				alert.setAlarmDate(cursor.getLong(1));
        				alert.setShown(cursor.getInt(2));
					
        				updateAlert(alert);
        				alertList.add(alert);
        				i++;
        			}
        		} while (cursor.moveToNext() && i < 1);
        	}	
        	db.close();
		
        	//sorts alerts by Date
        	Collections.sort(alertList, new Comparator<Alert>() {
        		@Override
        		public int compare(Alert a1, Alert a2) {
				
        			String compareDate = Long.toString(a1.getAlarmDate());
        			String thisDate = Long.toString(a2.getAlarmDate());
        			return thisDate.compareTo(compareDate);
        		}
			
        	});
        	return alertList;
	}

        /**
         * Update an alert to be marked as shown
         *
         * @param alert the alert
         * @return the int
         */
        private int updateAlert(Alert alert) {
        	
        	SQLiteDatabase db = this.getWritableDatabase();
		
        	ContentValues values = new ContentValues();
		
        	values.put(KEY_ALARM_DATE, alert.getAlarmDate());
        	values.put(KEY_SHOWN, 1);
        	
        	return db.update(TABLE_ALERTS, values, KEY_MESSAGE + " = ?",
        			new String[] { String.valueOf(alert.getMessage()) });
		
        }

}


