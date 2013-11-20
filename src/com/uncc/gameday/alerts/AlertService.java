package com.uncc.gameday.alerts;

import java.util.List;

import android.app.IntentService;
import android.content.Intent;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertService.
 */
public class AlertService extends IntentService {
	
	/** The Constant name. */
	private static final String name = "AlertService";

	/**
	 * Instantiates a new alert service.
	 */
	public AlertService() {
		super(name);
	}

	/* (non-Javadoc)
	 * @see android.app.IntentService#onHandleIntent(android.content.Intent)
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
		// Go fetch all the alerts!
		new AlertFetcher().fetchAlerts(this);
		List<Alert> alerts = new AlertDB().fetchUnread();
		
		// And then display all of them!
		for (Alert a: alerts) {
			a.displayNotification(this);
		}
	}

}
