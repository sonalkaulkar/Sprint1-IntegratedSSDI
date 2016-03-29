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

public class TestadddeliveryDao {
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
		selectSql = "SELECT * FROM DeliveryStaff where deliveryId = '123'";
		selectSql2 = "select * from login where username = 'Del1234'";
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			if(resultSet.getFetchSize() != 0) {
				throw new InvalidTestData("Invalid test delivery data state");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
		deliveryStaff DS = new deliveryStaff("123","Niel","jammu","niel@test.com",
				"7040001254","12345678","Jammu and Kashmir");
		Login l = new Login ("1234","1234");
		try {
			serviceDao.addDeliveryStaff(DS,l);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("deliveryId"), "123");
			assertEquals(resultSet.getString("deliveryName"), "Niel");
			assertEquals(resultSet.getString("location"), "jammu");
			assertEquals(resultSet.getString("delivery_email_id"), "niel@test.com");
			assertEquals(resultSet.getString("delivery_phone_no"), "7040001254");
			assertEquals(resultSet.getString("store_id"), "12345678");	
			assertEquals(resultSet.getString("delivery_add"), "Jammu and Kashmir");
		
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql2);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "Del1234");
			assertEquals(resultSet.getString("password"), "Del1234");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
