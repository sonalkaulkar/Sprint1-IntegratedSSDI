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

public class Testupdatepassword {
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
	public void testresetpassword() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String selectSql  = null;
		
		
		/* Verify current state of test database */
		String insertSql = "INSERT INTO login values('testusername','testp')";
		
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(insertSql);
			
		
				} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	Login L=new Login("testusername","testp",0);
		try {
			serviceDao.updatePassword(L,"NEWtest");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			selectSql = "select * from login where username='testusername'"; 
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "testusername");
			assertEquals(resultSet.getString("password"), "NEWtest");
					
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
