package com.uncc.gameday.alerts;

import java.util.Date;
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
			
		List<Alert> alerts = new AlertDB(this).fetchAll();
		
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
		@SuppressWarnings("deprecation")
		Alert a1 = new Alert(new Date(2003, 10, 10), "This is a test1", 0, AlertType.getValue(AlertType.ORGANIZATION));
		@SuppressWarnings("deprecation")
		Alert b = new Alert(new Date(2003, 10, 10), "This is a test2", 0, AlertType.getValue(AlertType.GAMEDAY));
		@SuppressWarnings("deprecation")
		Alert c = new Alert(new Date(2003, 10, 10), "This is a test3", 0, AlertType.getValue(AlertType.TIMED));
		
		AlertDB db = new AlertDB(this);
		
		db.persist(a1);
		db.persist(b);
		db.persist(c);
	}
}
