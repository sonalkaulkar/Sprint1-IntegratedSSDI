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

import model.*;
import util.db.connection.ConnectionUtil;
import util.db.connection.IConnectionData;
import util.db.connection.TestConnectionData;

public class ServicesDaoTest {
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
		String selectSql = null;
		
		/* Verify current state of test database */
		selectSql = "SELECT * FROM store where storeId = '1234'";
		
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
		Store S = new Store("1234", "ABC store","University terrace drive","charlotte" ,
								"9192918273", "xyz@gmail.com", 
								"", "","","");
		try {
			serviceDao.addStore(S);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("storeId"), "1234");
			assertEquals(resultSet.getString("storeName"), "ABC store");
			assertEquals(resultSet.getString("storeAdd"), "University terrace drive");
			assertEquals(resultSet.getString("storeLocation"), "charlotte");
			assertEquals(resultSet.getString("store_phone_no"), "9192918273");
			assertEquals(resultSet.getString("store_email_id"), "xyz@gmail.com");	
			assertEquals(resultSet.getString("manager"), "");
			assertEquals(resultSet.getString("manager_phone_no"), "");
			assertEquals(resultSet.getString("manager_email_id"), "");
			assertEquals(resultSet.getString("manager_username"), "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
