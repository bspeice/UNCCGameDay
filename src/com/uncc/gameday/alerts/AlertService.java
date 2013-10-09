package com.uncc.gameday.alerts;

import android.app.IntentService;
import android.content.Intent;

public class AlertService extends IntentService {
	private static final String name = "AlertService";

	public AlertService() {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// Go fetch all the alerts!
	}

}
