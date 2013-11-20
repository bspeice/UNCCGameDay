package com.uncc.gameday.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.uncc.gameday.R;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuActivity.
 */
public class MenuActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
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
