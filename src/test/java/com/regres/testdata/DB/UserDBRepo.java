package com.regres.testdata.DB;

public class UserDBRepo {
	public static UserDB getUser1() {
		return new UserDB("1","1","0","1","2017-09-30 12:58:27", "email@email.com","1",
				"aaaaaa","2017-09-28 12:58:27","aaaaaa","0","aaaaaaa","aaaaaaa","passward","1","ACTIVE","2","1","France","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
	public static UserDB getUserInactive() {
		return new UserDB("1","1","0","1","2017-09-30 12:58:27", "email@email.com","1",
				"aaaaaa","2017-09-28 12:58:27","aaaaaa","0","aaaaaaa","aaaaaaa","passward","1","INACTIVE","2","1","France","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
}
