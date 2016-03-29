package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

public class TestaddtechnicianDao {
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
	public void testaddTechnician() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String selectSql,selectSql2 = null;
		
		/* Verify current state of test database */
		selectSql = "SELECT * FROM technician where techId = '12345678'";
		selectSql2 = "SELECT * FROM login where username = 'TecAdam11'";
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
	Date d= new Date();
	Timestamp ts = new Timestamp(d.getTime());
		technician T = new technician("12345678","Adam","free",5,"adam@teststore.com",
				"7040000000","1234",ts);
		
		Login l = new Login("Adam11","Adam11");
		try {
			serviceDao.addTechnician(T, l);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("techId"), "12345678");
			assertEquals(resultSet.getString("techName"), "Adam");
			assertEquals(resultSet.getString("techstatus"), "free");
			assertEquals(resultSet.getString("tech_email_id"), "adam@teststore.com");
			assertEquals(resultSet.getString("tech_phone_no"), "7040000000");
			assertEquals(resultSet.getString("techstatus"), "free");	
			assertEquals(resultSet.getString("store_id"), "1234");
		//	assertEquals(resultSet.getString("last_completed_timestamp"), ts);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql2);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "TecAdam11");
			assertEquals(resultSet.getString("password"), "TecAdam11");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
