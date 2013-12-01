package com.uncc.gameday.parking;

// TODO: Auto-generated Javadoc
/**
 * The Enum RatingChoices.
 */
public enum RatingChoices {
	
	/** An Empty rating (0% full) */
	EMP ("EMPTY"),
	
	/** A Scattered rating (33% full) */
	SCT ("SCATTERED"),
	
	/** A Busy rating (66% full) */
	BSY ("BUSY"),
	
	/** A Full rating (100% full) */
	FLL ("FULL");
	
	/** The choice. */
	String choice;
	
	/**
	 * Instantiates a new rating choices.
	 *
	 * @param choice the choice
	 */
	RatingChoices(String choice) { this.choice = choice; }
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() { return choice; }
}
