package org.uncc.entities;
import org.uncc.exception.InvalidTestData;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidDataException;

import model.Store;


public class StoreTest {
	Store s;

	@Before
	public void setUp() throws Exception {
		s = new Store();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStoreId() {
			
			s.setStoreId("1");
		    String store_id = s.getStoreId();
					
		assertEquals(store_id,"1");
	}

	@Test
	public void testStoreName() {
			
			s.setStoreName("Store1");
		    String store_name = s.getStoreName();
					
		assertEquals(store_name,"Store1");
	}
	
	@Test
	public void testStoreAdd() {
			
			s.setStoreAdd("001, University terracce north");
		    String store_add = s.getStoreAdd();
					
		assertEquals(store_add,"001, University terracce north");
	}
	
	@Test
	public void testStoreLocation() {
			
			s.setStoreLocation("UTN");
		    String store_location = s.getStoreLocation();
					
		assertEquals(store_location,"UTN");
	}
	
	@Test
	public void testStorePhone() {
			
			s.setStore_Phone_No("0000000001");
		    String store_phone = s.getStore_Phone_No();
					
		assertEquals(store_phone,"0000000001");
	}
	
	@Test
	public void testStoreEmail() {
			
			s.setStore_Email_Id("store1@uncc.edu");
		    String store_email = s.getStore_Email_Id();
					
		assertEquals(store_email,"store1@uncc.edu");
	}
	
	@Test
	public void testmanager() {
			
			s.setManager("M1");
		    String manager = s.getManager();
					
		assertEquals(manager,"M1");
	}
	
	@Test
	public void testmanagerphone() {
			
			s.setManager_Phone_No("0000000001");
		    String manager_phone = s.getManager_Phone_No();
					
		assertEquals(manager_phone,"0000000001");
	}
	
	@Test
	public void testmanageremail() {
			
			s.setManager_Email_Id("manager1@uncc.edu");
		    String manager_email = s.getManager_Email_Id();
					
		assertEquals(manager_email,"manager1@uncc.edu");
	}
	
	@Test
	public void testmanagerusername() {
			
			s.setManager_Username("Manager1");
		    String manager_username = s.getManager_Username();
					
		assertEquals(manager_username,"Manager1");
	}
}
