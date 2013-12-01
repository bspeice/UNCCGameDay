package com.uncc.gameday.registration;

// TODO: Auto-generated Javadoc
/**
 * The Class Attendee.
 * Basic POJO for communicating information about people registered to attend
 * a game, and for sending that information to the server.
 */
public class Attendee {
	
	/** The id. */
	private int id;
	
	/** The first_name. */
	private String first_name;
	
	/** The last_name. */
	private String last_name;
	
	/** The section. */
	private String section;
	
	/** The row. */
	private int row;
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return first_name;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param first_name the new first name
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return last_name;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param last_name the new last name
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	/**
	 * Gets the section.
	 *
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
