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
		
		
		
		//VERY dirty code - just for the sake of testing
		//alert every 30 minutes staring at 9am to 930pm on 12-7-13
		Alert c1 = new Alert(new GregorianCalendar(2013, 11, 7, 9, 0).getTimeInMillis(), "Auto Alert 9:00a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c2 = new Alert(new GregorianCalendar(2013, 11, 7, 9, 30).getTimeInMillis(), "Auto Alert 9:30a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c3 = new Alert(new GregorianCalendar(2013, 11, 7, 10, 0).getTimeInMillis(), "Auto Alert 10:00a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c4 = new Alert(new GregorianCalendar(2013, 11, 7, 10, 30).getTimeInMillis(), "Auto Alert 10:30a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c5 = new Alert(new GregorianCalendar(2013, 11, 7, 11, 0).getTimeInMillis(), "Auto Alert 11:00a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c6 = new Alert(new GregorianCalendar(2013, 11, 7, 11, 30).getTimeInMillis(), "Auto Alert 11:30a", 0, AlertType.getValue(AlertType.TIMED));
		Alert c7 = new Alert(new GregorianCalendar(2013, 11, 7, 12, 0).getTimeInMillis(), "Auto Alert 12:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c8 = new Alert(new GregorianCalendar(2013, 11, 7, 12, 30).getTimeInMillis(), "Auto Alert 12:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c9 = new Alert(new GregorianCalendar(2013, 11, 7, 13, 0).getTimeInMillis(), "Auto Alert 1:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c10 = new Alert(new GregorianCalendar(2013, 11, 7, 13, 30).getTimeInMillis(), "Auto Alert 1:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c11 = new Alert(new GregorianCalendar(2013, 11, 7, 14, 0).getTimeInMillis(), "Auto Alert 2:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c12= new Alert(new GregorianCalendar(2013, 11, 7, 14, 30).getTimeInMillis(), "Auto Alert 2:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c13 = new Alert(new GregorianCalendar(2013, 11, 7, 15, 0).getTimeInMillis(), "Auto Alert 3:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c14 = new Alert(new GregorianCalendar(2013, 11, 7, 15, 30).getTimeInMillis(), "Auto Alert 3:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c15 = new Alert(new GregorianCalendar(2013, 11, 7, 16, 0).getTimeInMillis(), "Auto Alert 4:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c16 = new Alert(new GregorianCalendar(2013, 11, 7, 16, 30).getTimeInMillis(), "Auto Alert 4:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c17 = new Alert(new GregorianCalendar(2013, 11, 7, 17, 0).getTimeInMillis(), "Auto Alert 5:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c18 = new Alert(new GregorianCalendar(2013, 11, 7, 17, 30).getTimeInMillis(), "Auto Alert 5:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c19 = new Alert(new GregorianCalendar(2013, 11, 7, 18, 0).getTimeInMillis(), "Auto Alert 6:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c20 = new Alert(new GregorianCalendar(2013, 11, 7, 18, 30).getTimeInMillis(), "Auto Alert 6:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c21 = new Alert(new GregorianCalendar(2013, 11, 7, 19, 0).getTimeInMillis(), "Auto Alert 7:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c22 = new Alert(new GregorianCalendar(2013, 11, 7, 19, 30).getTimeInMillis(), "Auto Alert 7:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c23 = new Alert(new GregorianCalendar(2013, 11, 7, 20, 0).getTimeInMillis(), "Auto Alert 8:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c24 = new Alert(new GregorianCalendar(2013, 11, 7, 20, 30).getTimeInMillis(), "Auto Alert 8:30p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c25 = new Alert(new GregorianCalendar(2013, 11, 7, 21, 0).getTimeInMillis(), "Auto Alert 9:00p", 0, AlertType.getValue(AlertType.TIMED));
		Alert c26 = new Alert(new GregorianCalendar(2013, 11, 7, 21, 30).getTimeInMillis(), "Auto Alert 9:30p", 0, AlertType.getValue(AlertType.TIMED));
		
		
		AlertDB db = new AlertDB(this);
		
		db.persist(a1);
		db.persist(a2);
		db.persist(a3);
		db.persist(b1);
		db.persist(b2);
		db.persist(c1);
		db.persist(c2);
		db.persist(c3);
		db.persist(c4);
		db.persist(c5);
		db.persist(c6);
		db.persist(c7);
		db.persist(c8);
		db.persist(c9);
		db.persist(c10);
		db.persist(c11);
		db.persist(c12);
		db.persist(c13);
		db.persist(c14);
		db.persist(c15);
		db.persist(c16);
		db.persist(c17);
		db.persist(c18);
		db.persist(c19);
		db.persist(c20);
		db.persist(c21);
		db.persist(c22);
		db.persist(c23);
		db.persist(c24);
		db.persist(c25);
		db.persist(c26);
		
	}
	
	

}
