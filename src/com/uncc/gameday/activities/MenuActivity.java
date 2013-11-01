package com.uncc.gameday.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.uncc.gameday.R;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()){
    		case R.id.action_alert_settings:
    			startActivity(new Intent(this, Alerts.class));
    			break;
    		case R.id.action_registration:
    			startActivity(new Intent(this, Registration.class));
    			break;
    		case R.id.action_parking:
    			startActivity(new Intent(this, Parking.class));
    			break;
    		case R.id.action_home:
    			startActivity(new Intent(this, Home.class));
    			break;
    	}
		return true;
    }

}
