package com.regres.testdata;

public enum AddNewResourceLocalization {
	UA_SAVE("Намалюйте хоч одну територію на мапі."),
	UA_ADD_POINT("Будь ласка, введіть значення координат першої точки."),
	UA_THREE_POINTS("Введіть мінімум 3 точки"),
	UA_DELETE_POINT("Видалити останню точку не можливо."),
	RU_SAVE("Нарисуйте хоть одну территорию на карте."),
	RU_ADD_POINT("Пожалуйста, введите значения координат первой точки."),
	RU_THREE_POINTS("Введите минимум 3 точки"),
	RU_DELETE_POINT("Удалить последнюю точку невозможно."),
	EN_SAVE("Draw at least one territory on the map."),
	EN_ADD_POINT("Enter the coordinates of the first point."),
	EN_THREE_POINTS("Enter at least 3 points"),
	EN_DELETE_POINT("It is not possible to delete the last point."),
	EMPTY_FIELDS_MESSAGE("Заполните это поле.");
	
	//message
	private String message;
	/**
	 * constructor
	 * @param message - change password message
	 */
	AddNewResourceLocalization(String message) {
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
