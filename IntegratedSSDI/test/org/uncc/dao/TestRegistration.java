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
import model.orderObserve.Observer.Customer;
import util.db.connection.ConnectionUtil;
import util.db.connection.IConnectionData;
import util.db.connection.TestConnectionData;

public class TestRegistration {
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
		selectSql = "SELECT * FROM customer where customerId = 1";
		selectSql2 = "select * from login where username = 'CusSonal123'";
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
		Customer cus = new Customer("1","sonal","mahim","sonal1@gmail.com","787878787","fhdsf");
        Login l = new Login("Sonal123","Sonal123",0);
		try {
			serviceDao.registration(cus, l);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("customerId"), "1");
			assertEquals(resultSet.getString("customerName"), "sonal");
			assertEquals(resultSet.getString("location"), "mahim");
			assertEquals(resultSet.getString("customer_email_id"), "sonal1@gmail.com");
			assertEquals(resultSet.getString("customer_phone_no"), "787878787");
			assertEquals(resultSet.getString("customer_add"), "fhdsf");	
			//assertEquals(resultSet.getString("delivery_add"), "Jammu and Kashmir");
		
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql2);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "CusSonal123");
			assertEquals(resultSet.getString("password"), "Sonal123");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
