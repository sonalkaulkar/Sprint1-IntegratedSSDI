package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class TestDeleteDelivery {
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
	public void testchecklogin() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		PreparedStatement statement = null;
	
		ResultSet resultSet = null;
		String insertSql = null;
		String selectSql = "select * from deliverystaff where deliveryId  = ?";
		
		/* Verify current state of test database */
		
			insertSql = "insert into deliverystaff values('4','Adam','mahim','adam@kf.com','7040000000','1',0,'adams palace')";
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.prepareStatement(insertSql);
	
		    statement.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	  deliveryStaff d1 = new deliveryStaff("4");
		try {
			serviceDao.deletedelivery(d1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly fetched */ 
		try {
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, d1.getDeliveryId());
			resultSet = statement.executeQuery();
			
			
			assertFalse(resultSet.next());
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
