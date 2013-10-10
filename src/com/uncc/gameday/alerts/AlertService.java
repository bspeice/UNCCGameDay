package com.uncc.gameday.alerts;

import java.util.List;

import com.uncc.gameday.GameDay;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class AlertService extends IntentService {
	private static final String name = "AlertService";

	public AlertService() {
		super(name);
	}

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
