package com.uncc.gameday.parking;

// TODO: Auto-generated Javadoc
/**
 * The Enum RatingChoices.
 */
public enum RatingChoices {
	
	/** The emp. */
	EMP ("EMPTY"),
	
	/** The sct. */
	SCT ("SCATTERED"),
	
	/** The bsy. */
	BSY ("BUSY"),
	
	/** The fll. */
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
