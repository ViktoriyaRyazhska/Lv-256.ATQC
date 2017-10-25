package com.regres.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ResourcesTable {
	String resourceDescription;
	String subclass;
	String identificator;
	String inputDate;
	String more;

	public ResourcesTable(String resourceDescription, String subclass, String identificator, String inputDate,
			String more) {
		super();
		this.resourceDescription = resourceDescription;
		this.subclass = subclass;
		this.identificator = identificator;
		this.inputDate = inputDate;
		this.more = more;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public String getSubclass() {
		return subclass;
	}

	public String getIdentificator() {
		return identificator;
	}

	public String getInputDate() {
		return inputDate;
	}

	public String getMore() {
		return more;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public void setMore(String more) {
		this.more = more;
	}

	@Override
	public String toString() {
		return "ResourcesTable [resourceDescription=" + resourceDescription + ", subclass=" + subclass
				+ ", identificator=" + identificator + ", inputDate=" + inputDate + ", more=" + more + "]";
	}
	

	

}
