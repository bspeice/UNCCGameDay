package com.uncc.gameday.activities;

import com.uncc.gameday.R;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Alerts extends MenuActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alerts);
	}
	
	public void onClickTimedAlerts(View view) {
		if (((CheckBox) view).isChecked())
			// Enable Timed alerts
			;
		else
			// Disable Timed alerts
			;
	}
	
	public void onClickOrganizationAlerts(View view) {
		if (((CheckBox) view).isChecked())
			// Enable Organization alerts
			;
		else
			// Disable Organization alerts
			;
	}
	
	public void onClickUniversityAlerts(View view) {
		if (((CheckBox) view).isChecked())
			// Enable University alerts
			;
		else
			// Disable University alerts
			;
	}
	}
}
