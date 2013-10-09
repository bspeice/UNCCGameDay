package com.uncc.gameday.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

import com.uncc.gameday.R;
import com.uncc.gameday.alerts.AlertFetcher;

public class Home extends MenuActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Context ctx = getApplicationContext();
		this.onFirstRun(ctx);
	}
	
	protected void onFirstRun(Context ctx) {
		SharedPreferences settings = this.getPreferences(MODE_PRIVATE);
		if (settings.getBoolean("FIRST_RUN", true)) {
			// First run code
			
			Editor editor = settings.edit();
			editor.putBoolean("FIRST_RUN", false);
			editor.commit();
		}
	}
	
	private void getRecentAlerts() {
		// Responsible for discovering what the most recent alerts are and showing them.
		// Likely should be implemented by querying a local DB of alerts, grabbing recent 20.
		
	}
}
