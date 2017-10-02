package com.regres.application;

public final class ApplicationSourcesRepo {
	
	private ApplicationSourcesRepo() {  }

	public static ApplicationSources getFirefoxHerokuApplication() {
	  return new ApplicationSources("FireFox", "resources\\geckodriver.exe",
		"http://regres.herokuapp.com/login",
		"http://regres.herokuapp.com/logout", 5L);
	}

	public static ApplicationSources getChromeHerokuApplication() {
	  return new ApplicationSources("Chrome",
		"resources\\chromedriver.exe",
		"http://regres.herokuapp.com/login",
		"http://regres.herokuapp.com/logout", 5L);
	}

	public static ApplicationSources getFirefoxHerokuApplicationDB() {
		  return new ApplicationSources("FireFox", "resources\\geckodriver.exe",
			"http://regres.herokuapp.com/login",
			"http://regres.herokuapp.com/logout", 5L, "jdbc:mysql://localhost:3306/registrator_db","root","root");
		}
	
	public static ApplicationSources getChromeHerokuLocalhost() {
		return new ApplicationSources("Chrome",
				"resources\\chromedriver.exe",
				"http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout", 5L);
		
	}
	public static ApplicationSources getFirefoxHerokuLocalhost() {
		return new ApplicationSources("Firefox",
				"resources\\gechodriver.exe",
				"http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout", 5L);
		
	}
	
	
}



