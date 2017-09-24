package framework.application;

public class ApplicationSources {

	// Browser Data
	private String browserName;
	private String driverPath;
	//private String browserPath;
	//private String defaulProfile;
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	//private long explicitTimeOut;
	// Localization Strategy
	//private String language;
	//private String searchStrategy;
	//private String loggerStrategy;
	// URLs
	private String loginUrl;
	private String logoutUrl;

	public ApplicationSources(String browserName, String driverPath, 
			String loginUrl, String logoutUrl, long implicitTimeOut) {
			this.browserName = browserName;
			this.driverPath = driverPath;
			this.loginUrl = loginUrl;
			this.logoutUrl = logoutUrl;
			this.implicitTimeOut = implicitTimeOut;
			}

	public String getBrowserName() {
		return browserName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}
	
	public void setBrowserName(String browserName) {
		  this.browserName = browserName;
		}

	public void setDriverPath(String driverPath) {
		  this.driverPath = driverPath;
		}

	public void setImplicitTimeOut(long implicitTimeOut) {
		  this.implicitTimeOut = implicitTimeOut;
		}

	public void setLoginUrl(String loginUrl) {
		  this.loginUrl = loginUrl;
		}

	public void setLogoutUrl(String logoutUrl) {
		  this.logoutUrl = logoutUrl;
		}


}



