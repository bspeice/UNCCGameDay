package com.uncc.gameday.alerts;

import java.util.Date;

import com.uncc.gameday.R;
import com.uncc.gameday.activities.Home;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Alert.
 */
public class Alert {
	
	/** The alarm date. */
	private Date alarmDate;
	
	/** The message. */
	private String message;
	
	/** The shown. */
	private boolean shown;
	
	// Default constructor
	/**
	 * Instantiates a new alert.
	 */
	public Alert(){}
	
	/**
	 * Instantiates a new alert.
	 *
	 * @param alarmDate the alarm date
	 * @param message the message
	 * @param shown the shown
	 */
	public Alert(Date alarmDate, String message, boolean shown) {
		this.setAlarmDate(alarmDate);
		this.setMessage(message);
		this.setShown(shown);
	}
	
	/**
	 * Gets the alarm date.
	 *
	 * @return the alarm date
	 */
	public Date getAlarmDate() {
		return alarmDate;
	}
	
	/**
	 * Sets the alarm date.
	 *
	 * @param alarmDate the new alarm date
	 */
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Checks if is shown.
	 *
	 * @return true, if is shown
	 */
	public boolean isShown() {
		return shown;
	}
	
	/**
	 * Sets the shown.
	 *
	 * @param shown the new shown
	 */
	public void setShown(boolean shown) {
		this.shown = shown;
	}
	
	/**
	 * Display notification.
	 *
	 * @param ctx the ctx
	 */
	public void displayNotification(Context ctx) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle(ctx.getString(R.string.app_name))
			.setContentText(this.getMessage());
		
		Intent resultIntent = new Intent(ctx, Home.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
		stackBuilder.addParentStack(Home.class);
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent =	stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(resultPendingIntent);
		
		NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(0, builder.setAutoCancel(true).build());
	}

}
