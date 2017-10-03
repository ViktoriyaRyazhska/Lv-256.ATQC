package com.regres.testdata;
/**
 * Enum of unblockAllCoowners messages in diferent localization 
 * @author Юрій
 *
 */
public enum UnblockAllCoownersMessageLocalization {
	UA_MESSAGE("Ви успішно розблокували всіх співвласників"),
	RU_MESSAGE("Вы успешно разблокировали всех совладельцев!"),
	EN_MESSAGE("Youve successfully unblocked all coowners!");
	
	
	//message
	private String message;
	/**
	 * constructor
	 * @param message - change password message
	 */
	UnblockAllCoownersMessageLocalization(String message) {
		this.message = message;
	}
//getter and setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
