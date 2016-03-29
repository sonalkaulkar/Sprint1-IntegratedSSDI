package org.uncc.util;

public class TestConnectionData implements IConnectionData {
	// Driver
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// Database URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi_test";
	// Database credentials
	private static final String USERNAME = "root";
	private static final String PASSWORD = "UnccSonal11";

	@Override
	public String getDriver() {
		// TODO Auto-generated method stub
		return JDBC_DRIVER;
	}

	@Override
	public String getDBURL() {
		// TODO Auto-generated method stub
		return DB_URL;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return USERNAME;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return PASSWORD;
	}

}
