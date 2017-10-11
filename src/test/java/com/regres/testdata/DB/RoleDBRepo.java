package com.regres.testdata.DB;

public class RoleDBRepo {
	public static RoleDB getRoleAdmin() {
		return new RoleDB("Адміністратор","1");
	}
	public static RoleDB getRoleCoowner() {
		return new RoleDB("Співвласник","3");
	}
	public static RoleDB getRoleCommissioner() {
		return new RoleDB("Коммісіонер","4");
	}
	public static RoleDB getRoleRegistrator() {
		return new RoleDB("Реєстратор","2");
	}
	public static RoleDB getRoleAdminDB() {
		return new RoleDB("admin","1");
	}
	public static RoleDB getRoleCoownerDB() {
		return new RoleDB("User","3");
	}
	public static RoleDB getRoleCommissionerDB() {
		return new RoleDB("commissioner","4");
	}
	public static RoleDB getRoleRegistratorDB() {
		return new RoleDB("registrator","2");
	}
}
