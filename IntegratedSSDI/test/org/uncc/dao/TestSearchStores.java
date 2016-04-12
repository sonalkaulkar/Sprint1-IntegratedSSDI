package org.uncc.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.uncc.exception.InvalidTestData;
import org.uncc.util.ConnectionUtil;
import org.uncc.util.IConnectionData;
import org.uncc.util.TestConnectionData;

import model.*;

public class TestSearchStores {
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
		String insertSql = "insert into store values(1,'abc',' abc lane mahim','mahim',5675675656,'jhfd@jgf.com','sashi','sashi',5675675667,'jdhj@jjf.com')";
		
		
		connection = ConnectionUtil.getConnection(connectionData);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(insertSql);
			insertSql = "insert into store values(2,'cde',' cde lane mahim','mahim',5675675656,'jhfd@jgf.com','sashi','sashi',5675675667,'jdhj@jjf.com')";
			statement.executeUpdate(insertSql);
			insertSql = "insert into store values(3,'fgh',' fgh lane bandra','bandra',5675675656,'jhfd@jgf.com','sashi','sashi',5675675667,'jdhj@jjf.com')";
			statement.executeUpdate(insertSql);
			insertSql = "insert into product values(1,'Computer','DELL')";
			statement.executeUpdate(insertSql);
			insertSql = "insert into product values(2,'Computer','Lenovo')";
			statement.executeUpdate(insertSql);
			insertSql = "insert into storeproduct values(2,2)";
			statement.executeUpdate(insertSql);
			insertSql = "insert into storeproduct values(3,2)";
			statement.executeUpdate(insertSql);
			insertSql = "insert into storeproduct values(1,1)";
			statement.executeUpdate(insertSql);
			
		
				} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* Invoke function under test */
	product p = new product("","Computer","DELL");
	product p1 = new product("","Computer","Lenovo");
	ArrayList<Store> slist1 = new ArrayList();
	ArrayList<Store> slist2 = new ArrayList();
	ArrayList<Store> slist3 = new ArrayList();
		try {
			 
			 slist1 = serviceDao.searchStores(p,"mahim");
			 slist2 = serviceDao.searchStores(p1,"");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Verify that search  was correct */ 
		try {
		     Store s = slist1.get(0);
			assertEquals(s.getStoreName(), "abc");
			 s = slist2.get(0);
				assertEquals(s.getStoreName(), "cde");
			s = slist2.get(1);
			assertEquals(s.getStoreName(), "fgh");
			

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
