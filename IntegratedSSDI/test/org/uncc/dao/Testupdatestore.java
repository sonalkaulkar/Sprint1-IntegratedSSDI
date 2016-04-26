package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.uncc.exception.InvalidTestData;

import model.*;
import util.db.connection.ConnectionUtil;
import util.db.connection.IConnectionData;
import util.db.connection.TestConnectionData;

public class Testupdatestore {
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
	public void testupdateStore() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String selectSql  = null;
		
		/* Verify current state of test database */
		String insertSql = "INSERT INTO Store values ('123','Teststore','Charlotte','xyz','7041111111','teststore@test.com','','','','')";
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(insertSql);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	Store S= new Store("123", "Sasi", "New york", "USA", "7041541236", "sasi@test.com", "", "", "", "");
		try {
			serviceDao.updateStore(S);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			selectSql = "select * from store where storeId='123'"; 
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("storeId"), "123");
			assertEquals(resultSet.getString("storeName"), "Sasi");
			assertEquals(resultSet.getString("storeLocation"), "USA");
			assertEquals(resultSet.getString("storeAdd"), "New york");
			assertEquals(resultSet.getString("store_phone_no"), "7041541236");
			assertEquals(resultSet.getString("store_email_id"), "sasi@test.com");	
			
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
