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

public class TestAddProduct {
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
		selectSql = "SELECT * FROM storeproduct where storeId = 1 and prodId = 1 ";
		
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
		product  p = new product("","Computer","DELL");
		int store_id = 1;
		try {
			serviceDao.addProduct(p, store_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("storeId"), "1");
			assertEquals(resultSet.getString("prodId"), "1");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
