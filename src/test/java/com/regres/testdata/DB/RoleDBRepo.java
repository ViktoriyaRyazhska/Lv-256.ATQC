package com.regres.testdata.DB;

public class RoleDBRepo {
	public static RoleDB getRoleAdmin() {
		return new RoleDB("Адміністратор");
	}
	public static RoleDB getRoleCoowner() {
		return new RoleDB("Співвласник");
	}
	public static RoleDB getRoleCommissioner() {
		return new RoleDB("Коммісіонер");
	}
	public static RoleDB getRoleRegistrator() {
		return new RoleDB("Реєстратор");
	}
}
