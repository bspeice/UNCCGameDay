package com.uncc.gameday.alerts;

import java.util.Date;

public class Alert {
	
	private Date alarmDate;
	private String message;
	
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

}
