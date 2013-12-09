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
		Alert c1 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 0).getTimeInMillis(), "Auto Alert queued for: 10:00am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c2 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 5).getTimeInMillis(), "Auto Alert queued for: 10:05am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c3 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 10).getTimeInMillis(), "Auto Alert queued for: 10:10am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c4 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 15).getTimeInMillis(), "Auto Alert queued for: 10:15am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c5 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 20).getTimeInMillis(), "Auto Alert queued for: 10:20am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c6 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 25).getTimeInMillis(), "Auto Alert queued for: 10:25am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c7 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 30).getTimeInMillis(), "Auto Alert queued for: 10:30am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c8 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 35).getTimeInMillis(), "Auto Alert queued for: 10:40am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c9 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 40).getTimeInMillis(), "Auto Alert queued for: 10:45am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c10 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 45).getTimeInMillis(), "Auto Alert queued for: 10:50am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c11 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 50).getTimeInMillis(), "Auto Alert queued for: 10:55am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c12 = new Alert(new GregorianCalendar(2013, 11, 9, 10, 55).getTimeInMillis(), "Auto Alert queued for: 11:00am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c13 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 0).getTimeInMillis(), "Auto Alert queued for: 11:05am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c14 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 10).getTimeInMillis(), "Auto Alert queued for: 11:10am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c15 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 15).getTimeInMillis(), "Auto Alert queued for: 11:15am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c16 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 20).getTimeInMillis(), "Auto Alert queued for: 11:20am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c17 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 25).getTimeInMillis(), "Auto Alert queued for: 11:25am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c18 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 30).getTimeInMillis(), "Auto Alert queued for: 11:30pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c19 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 35).getTimeInMillis(), "Auto Alert queued for: 11:35am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c20 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 40).getTimeInMillis(), "Auto Alert queued for: 11:40am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c21 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 45).getTimeInMillis(), "Auto Alert queued for: 11:45am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c22 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 50).getTimeInMillis(), "Auto Alert queued for: 11:50am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c23 = new Alert(new GregorianCalendar(2013, 11, 9, 11, 55).getTimeInMillis(), "Auto Alert queued for: 11:55am", 0, AlertType.getValue(AlertType.TIMED));
		Alert c24 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 0).getTimeInMillis(), "Auto Alert queued for: 12:00pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c25 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 5).getTimeInMillis(), "Auto Alert queued for: 12:05pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c26 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 10).getTimeInMillis(), "Auto Alert queued for: 12:10pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c27 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 15).getTimeInMillis(), "Auto Alert queued for: 12:15pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c28 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 20).getTimeInMillis(), "Auto Alert queued for: 12:20pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c29 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 25).getTimeInMillis(), "Auto Alert queued for: 12:25pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c30 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 30).getTimeInMillis(), "Auto Alert queued for: 12:30pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c31 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 35).getTimeInMillis(), "Auto Alert queued for: 12:35pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c32 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 40).getTimeInMillis(), "Auto Alert queued for: 12:40pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c33 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 45).getTimeInMillis(), "Auto Alert queued for: 12:45pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c34 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 50).getTimeInMillis(), "Auto Alert queued for: 12:50pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c35 = new Alert(new GregorianCalendar(2013, 11, 9, 12, 55).getTimeInMillis(), "Auto Alert queued for: 12:55pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c36 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 0).getTimeInMillis(), "Auto Alert queued for: 01:00pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c37 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 5).getTimeInMillis(), "Auto Alert queued for: 01:05pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c38 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 10).getTimeInMillis(), "Auto Alert queued for: 01:10pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c39 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 15).getTimeInMillis(), "Auto Alert queued for: 01:15pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c40 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 20).getTimeInMillis(), "Auto Alert queued for: 01:20pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c41 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 25).getTimeInMillis(), "Auto Alert queued for: 01:25pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c42 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 30).getTimeInMillis(), "Auto Alert queued for: 01:30pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c43 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 35).getTimeInMillis(), "Auto Alert queued for: 01:35pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c44 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 40).getTimeInMillis(), "Auto Alert queued for: 01:40pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c45 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 45).getTimeInMillis(), "Auto Alert queued for: 01:45pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c46 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 50).getTimeInMillis(), "Auto Alert queued for: 01:50pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c47 = new Alert(new GregorianCalendar(2013, 11, 9, 13, 55).getTimeInMillis(), "Auto Alert queued for: 01:55pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c48 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 0).getTimeInMillis(), "Auto Alert queued for: 02:00pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c49 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 5).getTimeInMillis(), "Auto Alert queued for: 02:05pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c50 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 10).getTimeInMillis(), "Auto Alert queued for: 02:10pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c51 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 15).getTimeInMillis(), "Auto Alert queued for: 02:15pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c52 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 20).getTimeInMillis(), "Auto Alert queued for: 02:20pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c53 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 25).getTimeInMillis(), "Auto Alert queued for: 02:25pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c54 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 30).getTimeInMillis(), "Auto Alert queued for: 02:30pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c55 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 35).getTimeInMillis(), "Auto Alert queued for: 02:35pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c56 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 40).getTimeInMillis(), "Auto Alert queued for: 02:40pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c57 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 45).getTimeInMillis(), "Auto Alert queued for: 02:45pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c58 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 50).getTimeInMillis(), "Auto Alert queued for: 02:50pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c59 = new Alert(new GregorianCalendar(2013, 11, 9, 14, 55).getTimeInMillis(), "Auto Alert queued for: 02:55pm", 0, AlertType.getValue(AlertType.TIMED));
		Alert c60 = new Alert(new GregorianCalendar(2013, 11, 9, 15, 0).getTimeInMillis(), "Auto Alert queued for: 03:00pm", 0, AlertType.getValue(AlertType.TIMED));
		
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
		db.persist(c27);
		db.persist(c28);
		db.persist(c29);
		db.persist(c30);
		db.persist(c31);
		db.persist(c32);
		db.persist(c33);
		db.persist(c34);
		db.persist(c35);
		db.persist(c36);
		db.persist(c37);
		db.persist(c38);
		db.persist(c39);
		db.persist(c40);
		db.persist(c41);
		db.persist(c42);
		db.persist(c43);
		db.persist(c44);
		db.persist(c45);
		db.persist(c46);
		db.persist(c47);
		db.persist(c48);
		db.persist(c49);
		db.persist(c50);
		db.persist(c51);
		db.persist(c52);
		db.persist(c53);
		db.persist(c54);
		db.persist(c55);
		db.persist(c56);
		db.persist(c57);
		db.persist(c58);
		db.persist(c59);
		db.persist(c60);
		
	}
	
	

}
