package com.uncc.gameday.alerts;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.uncc.gameday.R;
import com.uncc.gameday.twitter.TwitterClient;

/**
 * The Class AlertFetcher.
 */
public class AlertFetcher {
	// Class responsible for fetching all alerts as necessary.

	/** The max tweets. */
	private int maxTweets = 5;

	/**
	 * Fetch all alerts - Twitter, timed, etc.
	 * 
	 * @param ctx
	 *            the ctx
	 */
	public void fetchAlerts(Context ctx) {
		// Fetch all alerts. Responsible for discovering what sources need to be
		// fetched.
		try {
			// Note we have to use the SharedPreferences so that we have
			// preferences no matter what activity
			// sent us this context
			SharedPreferences settings = ctx.getSharedPreferences(
					ctx.getString(R.string.preferences_file), 0); // MODE_PRIVATE

			// Fetch organization alerts
			this.fetchOrganizationAlerts(ctx);
			// Fetch university alerts
			this.fetchUniversityAlerts(ctx);
			// And always fetch alerts made by us. Period.
			
			this.fetchGamedayAlerts(ctx);
		} catch (TwitterException e) {
			Log.w("AlertFetcher", "Unable to fetch alerts from Twitter...", e);
		}
	}

	/**
	 * Fetch all Organization alerts from Twitter
	 * 
	 * @param ctx
	 *            - The Context needed to access the Internet
	 * @throws TwitterException
	 *             - Error in using the Twitter API
	 */
	private void fetchOrganizationAlerts(Context ctx) throws TwitterException {
		// Process fetching organization alerts (alerts retweeted by us)
		// Guaranteed to return <= maxTweets
		String handle = ctx.getString(R.string.gameday_handle);
		TwitterClient tc = new TwitterClient();
		List<Status> statuses = tc.fetchTweets(handle, maxTweets);

		// Filter for anything created by us (retweet)
		for (Iterator<Status> it = statuses.iterator(); it.hasNext();) {
			// May need to switch to isRetweetByMe, not sure if
			// We're using the right function (documentation is awful)
			if (!it.next().isRetweet())
				it.remove();
		}

		String type = AlertType.getValue(AlertType.ORGANIZATION);
		pushToDatabase(statuses, type, ctx);

		// List contains all valid alerts now
	}

	/**
	 * Fetch alerts from the University Twitter
	 * 
	 * @param ctx
	 *            - The Context for accessing the Internet
	 * @throws TwitterException
	 *             - Throws an exception for misuse of Twitter API
	 */
	private void fetchUniversityAlerts(Context ctx) throws TwitterException {
		// Process fetching university alerts
		// Guaranteed to get `maxTweets` tweets

		String handle = ctx.getString(R.string.university_handle);
		TwitterClient tc = new TwitterClient();
		List<Status> statuses = tc.fetchTweets(handle, maxTweets);

		String type = AlertType.getValue(AlertType.UNIVERSITY);
		pushToDatabase(statuses, type, ctx);
	}

	/**
	 * Fetch gameday alerts.
	 * 
	 * @param ctx
	 *            the ctx
	 * @throws TwitterException
	 *             the twitter exception
	 */
	private void fetchGamedayAlerts(Context ctx) throws TwitterException {
		// Process fetching alerts generated by staff of UNCCGameDay
		// Not guaranteed to get `maxTweets` tweets

		String handle = ctx.getString(R.string.gameday_handle);
		TwitterClient tc = new TwitterClient();
		List<Status> statuses = tc.fetchTweets(handle, maxTweets);

		// Filter out anything not from us
		for (Iterator<Status> it = statuses.iterator(); it.hasNext();) {
			// May need to switch to isRetweetByMe (documentation is awful)
			if (it.next().isRetweet())
				it.remove();
		}

		String type = AlertType.getValue(AlertType.GAMEDAY);
		pushToDatabase(statuses, type, ctx);

		// List contains all valid alerts now.

	}

	// takes list of statuses
	// converts it to Alert object type
	// and persists to database
	public void pushToDatabase(List<Status> statuses, String type, Context ctx) {
		GregorianCalendar todayDate = new GregorianCalendar();
		long currentDate = todayDate.getTimeInMillis();

		AlertDB db = new AlertDB(ctx);

		for (int i = 0; i < statuses.size(); i++) {
			Alert temp = new Alert(currentDate, statuses.get(i).getText(), 0,
					type);
			db.persist(temp);
		}
	}
}
