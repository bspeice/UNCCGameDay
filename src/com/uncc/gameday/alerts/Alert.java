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

public class Alert {
	
	private Date alarmDate;
	private String message;
	private boolean shown;
	
	// Default constructor
	public Alert(){}
	
	public Alert(Date alarmDate, String message, boolean shown) {
		this.setAlarmDate(alarmDate);
		this.setMessage(message);
		this.setShown(shown);
	}
	
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isShown() {
		return shown;
	}
	public void setShown(boolean shown) {
		this.shown = shown;
	}
	
	public void displayNotification(Context ctx) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle("GameDay Alert")
			.setContentText(this.getMessage());
		
		Intent resultIntent = new Intent(ctx, Home.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
		stackBuilder.addParentStack(Home.class);
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent =	stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(resultPendingIntent);
		
		NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(0, builder.build());
	}

}
