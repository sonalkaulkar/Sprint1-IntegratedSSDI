package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.uncc.exception.InvalidTestData;
import org.uncc.util.ConnectionUtil;
import org.uncc.util.IConnectionData;
import org.uncc.util.TestConnectionData;

import model.*;

public class TestPickUpOrder {
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
	public void testOrderHistory() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String selectSql  = null;
		
		  java.util.Date utilDate = new java.util.Date();
          Calendar cal = Calendar.getInstance();
          cal.setTime(utilDate);
          cal.set(Calendar.MILLISECOND, 0);
          java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime()); 
		/* Verify current state of test database */
		String insertSql = "insert into orderdetails values(1,?,1,'DELL',1,1,1,'Placed',1,'faulty mouse touch','')";
		
		
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.prepareStatement(insertSql);
			statement.setTimestamp(1, t);
			statement.executeUpdate();
			insertSql = "insert into orderdetails values(2,?,2,'Lenovo',1,2,1,'Placed',1,'faulty insert key','')";
			statement = connection.prepareStatement(insertSql);
			statement.setTimestamp(1, t);
			statement.executeUpdate();
			insertSql = "insert into orderdetails values(3,?,2,'Lenovo',1,2,1,'Placed',123,'faulty delete key','')";
			statement = connection.prepareStatement(insertSql);
			statement.setTimestamp(1, t);
			statement.executeUpdate();
			
			
			
			
		
				} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	String delivery_name = "Del1234" ;
	
	ArrayList<PickUpOrder> plist1 = new ArrayList();
	
		try {
			 
			 plist1 = serviceDao.viewPickUp(delivery_name);
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that search  was correct */ 
		try {
		     PickUpOrder p = plist1.get(0);
			assertEquals(p.getOrderId(), 2);
			 p = plist1.get(1);
				assertEquals(p.getOrderId(), 3);
			
			

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
