package org.uncc.util.copy;

public class ProductionConnectionData implements IConnectionData {
	// Driver
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// Database URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
	// Database credentials
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	public String getDriver() {
		
		return JDBC_DRIVER;
	}

	public String getDBURL() {
		
		return DB_URL;
	}

	public String getUserName() {
		
		return USERNAME;
	}

	public String getPassword() {
		
		return PASSWORD;
	}
}
