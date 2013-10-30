package com.uncc.gameday.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;

import com.uncc.gameday.R;
import com.uncc.gameday.alerts.AlertService;

public class Home extends MenuActivity {
	
	private TableLayout alertsScrollView;
	
	Button clearAlertsButton;
	Button getAlertsButton;
	
	private final long alarmRate = 300000; // 5 Minutes
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		alertsScrollView = (TableLayout) findViewById(R.id.alertsScrollView);
		
		clearAlertsButton = (Button) findViewById(R.id.clearAlertsButton);
		getAlertsButton = (Button) findViewById(R.id.getAlertsButton);
		
		clearAlertsButton.setOnClickListener(clearAlertsButtonListener);
		getAlertsButton.setOnClickListener(getAlertsButtonListener);
		
		updateAlertsList(null);
	
	
		
		// Start up the AlarmManager to fetch alerts in the background
		AlarmManager am = (AlarmManager) this.getSystemService(ALARM_SERVICE);
		Intent alertFetcher = new Intent(this, AlertService.class);
		PendingIntent pendingAlertFetcher = PendingIntent.getService(this, 0, alertFetcher, 0);
		
		// Cancel any previous alarm managers, and start the new one
		am.cancel(pendingAlertFetcher);
		am.setRepeating(0, this.alarmRate, this.alarmRate, pendingAlertFetcher);
		
		// Double check if we need to do any first-run code
		this.onFirstRun();
	}
	
	protected void onFirstRun() {
		SharedPreferences settings = this.getPreferences(MODE_PRIVATE);
		if (settings.getBoolean("FIRST_RUN", true)) {
			// First run code
			
			Editor editor = settings.edit();
			editor.putBoolean("FIRST_RUN", false);
			editor.commit();
		}
	}
}
