package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.uncc.exception.InvalidTestData;
import org.uncc.util.ConnectionUtil;
import org.uncc.util.IConnectionData;
import org.uncc.util.TestConnectionData;

import model.*;

public class TestaddmanagerDao {
	private static ServicesDaoFactory factory;
	private ServicesDao serviceDao;
	
	@BeforeClass
	public static void myInitialization() throws Exception {
		factory = ServicesDaoFactory.getInstance("test");
	}
	
	@Before
	public void setUp() throws Exception {
		serviceDao = factory.createServiceDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddStore() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String selectSql ,selectSql2 = null;
		
		/* Verify current state of test database */
		selectSql = "SELECT * FROM store where storeId = '1234'";
		selectSql2 = "SELECT * FROM login where username = 'Strsonal11'";
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			if(resultSet.getFetchSize() != 0) {
				throw new InvalidTestData("Invalid test data state");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
		
		try {
			Store s = new Store("1234","","","","","","sonal","234567678","jhfkd@jfdk.com","sonal11");
			serviceDao.AddStoreManager(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("manager"), "sonal");
			assertEquals(resultSet.getString("manager_phone_no"), "234567678");
			assertEquals(resultSet.getString("manager_email_id"), "jhfkd@jfdk.com");
			assertEquals(resultSet.getString("manager_username"), "Strsonal11");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql2);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "Strsonal11");
			assertEquals(resultSet.getString("username"), "Strsonal11");
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
