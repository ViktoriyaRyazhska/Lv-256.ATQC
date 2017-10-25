package com.regres.testdata;

import org.openqa.selenium.WebElement;

public enum Coordinates {
	FIRST_POINT("49", "44", "56.4730985", "23", "30", "58.4472656"), 
	SECOND_POINT("49", "22", "56.542033234383666", "23", "53", "42.94921875"), 
	THIRD_POINT("49", "40", "54.64883784462984", "23", "18", "56.6455078125");

	// message
	private String latitudeDegreeField;
	private String latitudeMinuteField;
	private String latitudeSecondField;
	private String longitudeDegreeField;
	private String longitudeMinuteField;
	private String longitudeSecondField;

	/**
	 * constructor
	 * 
	 * @param message
	 *            - change password message
	 */
	Coordinates(String latitudeDegreeField, String latitudeMinuteField, String latitudeSecondField,
			String longitudeDegreeField, String longitudeMinuteField, String longitudeSecondField) {
		this.latitudeDegreeField = latitudeDegreeField;
		this.latitudeMinuteField = latitudeMinuteField;
		this.latitudeSecondField = latitudeSecondField;
		this.longitudeDegreeField = longitudeDegreeField;
		this.longitudeMinuteField = longitudeMinuteField;
		this.longitudeSecondField = longitudeSecondField;
	}

	public String getLatitudeDegreeField() {
		return latitudeDegreeField;
	}

	public String getLatitudeMinuteField() {
		return latitudeMinuteField;
	}

	public String getLatitudeSecondField() {
		return latitudeSecondField;
	}

	public String getLongitudeDegreeField() {
		return longitudeDegreeField;
	}

	public String getLongitudeMinuteField() {
		return longitudeMinuteField;
	}

	public String getLongitudeSecondField() {
		return longitudeSecondField;
	}

	public void setLatitudeDegreeField(String latitudeDegreeField) {
		this.latitudeDegreeField = latitudeDegreeField;
	}

	public void setLatitudeMinuteField(String latitudeMinuteField) {
		this.latitudeMinuteField = latitudeMinuteField;
	}

	public void setLatitudeSecondField(String latitudeSecondField) {
		this.latitudeSecondField = latitudeSecondField;
	}

	public void setLongitudeDegreeField(String longitudeDegreeField) {
		this.longitudeDegreeField = longitudeDegreeField;
	}

	public void setLongitudeMinuteField(String longitudeMinuteField) {
		this.longitudeMinuteField = longitudeMinuteField;
	}

	public void setLongitudeSecondField(String longitudeSecondField) {
		this.longitudeSecondField = longitudeSecondField;
	}

}
