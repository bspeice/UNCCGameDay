package com.uncc.gameday.alerts;

import java.util.GregorianCalendar;
import java.util.List;
import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertService.
 */
public class AlertService extends IntentService {
        
        /** The Constant name. */
        private static final String name = "AlertService";
        
        /** The prefs. */
        SharedPreferences prefs = null;

        /**
         * Instantiates a new alert service.
         */
        public AlertService() {
                super(name);
        }

        /**
         * Start the actual alert service
         * 
         * @param intent - The incoming intent that started us
         */
        @Override
        protected void onHandleIntent(Intent intent) {

        	
        		// Go fetch all the alerts!
            	new AlertFetcher().fetchAlerts(this);
            	
                //if first application run, create and store
                //timed alerts into database
                prefs = getSharedPreferences("com.uncc.gameday", MODE_PRIVATE);
                if(prefs.getBoolean("firstrun", true)){
                        onFirstRun();
                        prefs.edit().putBoolean("firstrun", false).commit();
                }
 
                List<Alert> alerts = new AlertDB(this).fetchUnread();
                
                // And then display all of them!
                for (Alert a: alerts) {
                        a.displayNotification(this);
                }
        }
       
        /**
         * Creates timed alerts and adds them to AlertDB
         * Only runs on first application startup
         */
	protected void onFirstRun()
	{
		//Sets date as (YYYY, MM, DD)
		//month runs from 0-11
		//10 = November
		//11 = December (max)
		GregorianCalendar cal = new GregorianCalendar(2013, 10, 30); 
		long date1 = cal.getTimeInMillis();
		GregorianCalendar cal2 = new GregorianCalendar(2013, 11, 3); 
		long date2 = cal2.getTimeInMillis();
		
		Alert a1 = new Alert(date1, "UNCC GAME DAY on Saturday, 12/7/13.  UNCC VS. NC State", 0, AlertType.getValue(AlertType.TIMED));
		
	
		Alert a2 = new Alert(date1, "Don't forget to purchase your ticket!  UNCC Gameday 12/7/13 @ 1pm", 0, AlertType.getValue(AlertType.TIMED));
		
		
		Alert a3 = new Alert(date1, "Don't forget to purchase your parking pass!  Deadline is 12/6/13 by 5pm", 0, AlertType.getValue(AlertType.TIMED));

		Alert b1 = new Alert(date2, "Will you be there?  UNCC GAME DAY Saturday, 12/7/13", 0, AlertType.getValue(AlertType.TIMED));
	
		Alert b2 = new Alert(date2, "TOWING ENFORCED: DON'T FORGET TO MOVE YOUR CAR OFF GAMEDAY PARKING LOTS", 0, AlertType.getValue(AlertType.TIMED));
		
		AlertDB db = new AlertDB(this);
		
		db.persist(a1);
		db.persist(a2);
		db.persist(a3);
		db.persist(b1);
		db.persist(b2);
	}
	
	

}
