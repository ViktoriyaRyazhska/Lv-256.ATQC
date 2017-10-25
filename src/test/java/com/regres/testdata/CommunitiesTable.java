package com.regres.testdata;

public class CommunitiesTable {
	String comName;
	String comRegNumber;

	@Override
	public String toString() {
		return "CommunitiesTable [comName=" + comName + ", comRegNumber=" + comRegNumber + "]";
	}

	public CommunitiesTable(String comName, String comRegNumber) {
		this.comName = comName;
		this.comRegNumber = comRegNumber;

	}

	public String getcomName() {
		return comName;
	}

	public String getcomRegNumber() {
		return comRegNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CommunitiesTable community = (CommunitiesTable) o;
		if (!comName.equals(community.comName))
			return false;
		if (!comRegNumber.equals(community.comRegNumber))
			return false;
		return comName.equals(community.comName) && comRegNumber.equals(community.comRegNumber);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + comName.hashCode();
		result = 31 * result + comRegNumber.hashCode();
		return result;
	}

}
