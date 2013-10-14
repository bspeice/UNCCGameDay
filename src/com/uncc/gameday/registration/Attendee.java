package com.uncc.gameday.registration;

import java.util.Date;

public class Attendee {
	
	private Date date_registered;
	private String first_name;
	private String last_name;
	private String section;
	private int row;
	
	public Date getDate_registered() {
		return date_registered;
	}
	public void setDate_registered(Date date_registered) {
		this.date_registered = date_registered;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	

}
