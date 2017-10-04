package com.regres.testdata;
/**
 * Enum of messages in diferent localization on changePasswordPage
 * @author Юрій
 *
 */
public enum ChangePasswordPageLocalization {
	UA_WRONG_PASSWORD("Неправильний пароль"),
	UA_WRONG_NEW_PASSWORD("Введіть коректний пароль [a-zA-Z0-9].{6,20}"),
	UA_WRONG_CONFIRM_PASSWORD("Підтвердження паролю неправильне"),
	UA_SUCCES_MESSAGE("Пароль успішно змінено"),
	RU_WRONG_PASSWORD("Неправильний пароль"),
	RU_WRONG_NEW_PASSWORD("Введите корректный пароль [a-zA-Z0-9].{6,20}"),
	RU_WRONG_CONFIRM_PASSWORD("Подтверждение пароля неправильное"),
	RU_SUCCES_MESSAGE("Пароль успешно изменен"),
	EN_WRONG_PASSWORD("Wrong password"),
	EN_WRONG_NEW_PASSWORD("Incorrect password [a-zA-Z0-9].{6,20}"),
	EN_WRONG_CONFIRM_PASSWORD("Bad confirmation"),
	EN_SUCCES_MESSAGE("Your password has been successfully updated"),
	EMPTY_FIELDS_MESSAGE("Заполните это поле.");
	
	//message
	private String message;
	/**
	 * constructor
	 * @param message - change password message
	 */
	ChangePasswordPageLocalization(String message) {
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
