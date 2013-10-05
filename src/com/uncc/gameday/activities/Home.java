package com.uncc.gameday.activities;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import android.content.Context;
import android.os.Bundle;

import com.uncc.gameday.R;

public class Home extends MenuActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Context ctx = getApplicationContext();
		
	}
	
	private void getRecentAlerts() {
		// Responsible for discovering what the most recent alerts are and showing them.
		// Likely should be implemented by querying a local DB of alerts, grabbing recent 20.
		new Alerts().fetchAlerts();
	}
}
