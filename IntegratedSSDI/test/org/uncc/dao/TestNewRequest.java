package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
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

public class TestNewRequest {
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
	public void testnewRequest() throws InvalidTestData {
		IConnectionData connectionData = new TestConnectionData();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String selectSql = null;
		
		/* Verify current state of test database */
				selectSql = "select * from orderdetails where orderId = ?";
				connection = ConnectionUtil.getConnection(connectionData);
		/* Invoke function under test */
		Store S = new Store("1");
		product p = new product("","Computer","DELL");
		String description = "faulty charger";
		String location = "mahim";
		String  cust_name = "CusSonal123" ;
		int order_id = 0 ;
		try {
			 order_id = serviceDao.newRequest(S,p,location,description,cust_name);
			 System.out.println(order_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that database was correctly updated */ 
		try {
			statement = connection.prepareStatement(selectSql);
			statement.setInt(1,order_id);
			resultSet = statement.executeQuery();
			
			resultSet.next();
			//assertEquals(resultSet.getString("orderId"), "1");
//			assertEquals(resultSet.getString("date_of_order"), "ABC store");
			assertEquals(resultSet.getString("prodId"), "1");
			assertEquals(resultSet.getString("make"), "DELL");
			assertEquals(resultSet.getInt("tech_id"), 1);
			assertEquals(resultSet.getInt("store_id"), 1);	
			assertEquals(resultSet.getInt("customer_id"), 1);
			assertEquals(resultSet.getString("order_status"), "Placed");
			System.out.println("Random selected delivery staff  "+resultSet.getInt("delivery_id"));
			assertEquals(resultSet.getString("description"), "faulty charger");
			assertEquals(resultSet.getString("payment_status"), "");			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
