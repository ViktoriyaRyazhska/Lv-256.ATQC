package com.regres.testdata.DB;

public class UserDBRepo {
	public static UserDB getUser1() {
		return new UserDB("1","1","0","1","2017-09-30 12:58:27", "email@email.com","1",
				"aaaaaa","2017-09-28 12:58:27","aaaaaa","0","aaaaaaa","aaaaaaa","passward","1","ACTIVE","2","1","Україна","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
	public static UserDB getUserInactive() {
		return new UserDB("1","1","0","1","2017-09-30 12:58:27", "email@email.com","1",
				"aaaaaa","2017-09-28 12:58:27","aaaaaa","0","aaaaaaa","aaaaaaa","passward","1","INACTIVE","2","1","France","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
	
	public static UserDB getUserNonConfirmed() {
		return new UserDB("1","1","0","1","2017-10-04 12:58:27", "bzhyvko90@gmail.com","1",
				"testemail","2017-09-28 12:58:27","testemail","0","testemail","testemail","19902712","1","NONCONFIRMED","2","1","France","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
	public static UserDB getUser2() {
		return new UserDB("1","1","0","1","2017-09-30 12:58:27", "email@email.com","1",
				"qwerty","2017-09-28 12:58:27","qwerty","0","qwerty","qwerty","qwerty","1","ACTIVE","2","1","Україна","Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.");
	}
}
