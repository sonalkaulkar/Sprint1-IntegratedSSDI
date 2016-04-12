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

public class TestDeleteTech {
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
		String selectSql = "select * from technician where techId = ?";
		
		/* Verify current state of test database */
		Date d= new Date();
		Timestamp ts = new Timestamp(d.getTime());
			
			insertSql = "insert into technician values('2','Adam','free',5,'adam@teststore.com','7040000000','1234',?)";
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.prepareStatement(insertSql);
			statement.setTimestamp(1, ts);
		    statement.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	  technician t = new technician("2");
		try {
			serviceDao.deleteTechnician(t);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly fetched */ 
		try {
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, t.getTechId());
			resultSet = statement.executeQuery();
			
			
			assertFalse(resultSet.next());
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
