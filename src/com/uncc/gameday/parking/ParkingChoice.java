package com.uncc.gameday.parking;

// TODO: Auto-generated Javadoc
/**
 * The Enum ParkingChoice.
 */
public enum ParkingChoice {
	
	/** The green. */
	GREEN ("GREEN"),
	
	/** The black. */
	BLACK ("BLACK"),
	
	/** The red. */
	RED ("RED"),
	
	/** The blue. */
	BLUE ("BLUE"),
	
	/** The silver. */
	SILVER ("SILVER"),
	
	/** The orange. */
	ORANGE ("ORANGE"),
	
	/** The yellow. */
	YELLOW ("YELLOW"),
	
	/** The purple. */
	PURPLE ("PURPLE"),
	
	/** The pink. */
	PINK ("PINK"),
	
	/** The white. */
	WHITE ("WHITE"),
	
	/** The gold. */
	GOLD ("GOLD");
	
	/** The choice. */
	String choice;
	
	/**
	 * Instantiates a new parking choice.
	 *
	 * @param choice the choice
	 */
	ParkingChoice(String choice) { this.choice = choice; }
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() { return choice; }
}