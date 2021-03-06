package com.regres.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ApplicationSources {

	// Browser Data
	private String browserName;
	private String driverPath;
	// private String browserPath;
	// private String defaulProfile;
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	// private long explicitTimeOut;
	// Localization Strategy
	// private String language;
	// private String searchStrategy;
	// private String loggerStrategy;
	// URLs
	private String loginUrl;
	private String logoutUrl;

	// Connection DB URL
	private static String DBmyUrl;
	// Database Username
	private static String username;
	// Database Password
	private static String password;

	private static Connection dbConnection;

	public ApplicationSources(String browserName, String driverPath, String loginUrl, String logoutUrl,
			long implicitTimeOut) {
		this.browserName = browserName;
		this.driverPath = driverPath;
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
		this.implicitTimeOut = implicitTimeOut;
	}

	public ApplicationSources(String browserName, String driverPath, String loginUrl, String logoutUrl,
			long implicitTimeOut, String DBmyUrl, String username, String password) {
		this.browserName = browserName;
		this.driverPath = driverPath;
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
		this.implicitTimeOut = implicitTimeOut;
		this.DBmyUrl = DBmyUrl;
		this.username = username;
		this.password = password;
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

	public static Connection createDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(DBmyUrl, username, password);
		if (dbConnection == null) {
			throw new SQLException("SQLException");
		}
		return dbConnection;
	}

	public static void closeConnectionDB() throws ClassNotFoundException, SQLException {
		if (dbConnection != null)
			dbConnection.close();
	}	
}
