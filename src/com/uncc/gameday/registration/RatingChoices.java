package com.uncc.gameday.registration;

public enum RatingChoices {
	EMPTY ("EMP"),
	SCATTERED ("SCT"),
	BUSY ("BSY"),
	FULL ("FLL");
	
	String choice;
	RatingChoices(String choice) { this.choice = choice; }
	public String getValue() { return choice; }
}
