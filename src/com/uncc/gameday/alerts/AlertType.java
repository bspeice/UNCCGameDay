package com.uncc.gameday.alerts;

public enum AlertType {

	TIMED ("TIMED"),
	ORGANIZATION ("ORGANIZATION"),
	UNIVERSITY ("UNIVERSITY"),
	GAMEDAY ("GAMEDAY");
	
	String type;
	AlertType(String type) {this.type = type; }
	public String getValue() { return type; }


	public static String getValue(AlertType type)
	{
		switch(type)
		{
		case TIMED:
			return "TIMED";
		case ORGANIZATION:
			return "ORGANIZATION";
		case UNIVERSITY:
			return "UNIVERSITY";
		default:
			return "GAMEDAY";
		}
	}
}