package com.uncc.gameday.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.uncc.gameday.R;

public class Alerts extends MenuActivity {
	
	Context ctx;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.ctx = getApplicationContext();
		setContentView(R.layout.activity_alerts);
	}
	
	public void onClickTimedAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable Timed alerts
			Toast.makeText(this.ctx, "Timed alerts enabled.", toastDuration).show();
		else
			// Disable Timed alerts
			Toast.makeText(this.ctx, "Timed alerts disabled.", toastDuration).show();
	}
	
	public void onClickOrganizationAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable Organization alerts
			Toast.makeText(this.ctx, "Organization alerts enabled.", toastDuration).show();
		else
			// Disable Organization alerts
			Toast.makeText(this.ctx, "Organization alerts disabled.", toastDuration).show();
	}
	
	public void onClickUniversityAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable University alerts
			Toast.makeText(this.ctx, "University alerts enabled.", toastDuration).show();
		else
			// Disable University alerts
			Toast.makeText(this.ctx, "University alerts disabled.", toastDuration).show();
	}
}
