package com.uncc.gameday.registration;

public enum RatingChoices {
	EMP ("EMPTY"),
	SCT ("SCATTERED"),
	BSY ("BUSY"),
	FLL ("FULL");
	
	String choice;
	RatingChoices(String choice) { this.choice = choice; }
	public String getValue() { return choice; }
}
