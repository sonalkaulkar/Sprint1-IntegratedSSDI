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

public class CheckLoginTest {
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
		Statement statement = null;
		ResultSet resultSet = null;
		String insertSql = null;
		String selectSql = "select * from login where username = 'Tec1234' and password = 'Tec1234'";
		
		/* Verify current state of test database */
		insertSql = "insert into login values('Tec1234','Tec1234')";
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
		    statement.executeUpdate(insertSql);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
		Login L= new Login("Tec1234", "Tec1234",0);
		try {
			serviceDao.checkLogin(L);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly fetched */ 
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			
			resultSet.next();
			assertEquals(resultSet.getString("username"), "Tec1234");
			assertEquals(resultSet.getString("password"), "Tec1234");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
