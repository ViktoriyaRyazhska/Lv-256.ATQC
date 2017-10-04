package com.regres.testdata;

public class GoogleEmailSearch {
	private String gmailSearchCommand;
	private String emailTitle;
	
	
	public GoogleEmailSearch() {
	}
	
	public GoogleEmailSearch(String gmailSearchCommand, String emailTitle) {
		this.gmailSearchCommand = gmailSearchCommand;
		this.emailTitle = emailTitle;
	}

	public String getGmailSearchCommand() {
		return gmailSearchCommand;
	}
	public String getEmailTitle() {
		return emailTitle;
	}
	public void setGmailSearchCommand(String gmailSearchCommand) {
		this.gmailSearchCommand = gmailSearchCommand;
	}
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	@Override
	public String toString() {
		return gmailSearchCommand + " " + emailTitle;
	}

}
