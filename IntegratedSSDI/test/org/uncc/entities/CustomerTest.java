package org.uncc.entities;
import org.uncc.exception.InvalidTestData;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidDataException;

import model.orderObserve.Observer.Customer;


public class CustomerTest {
	Customer c;

	@Before
	public void setUp() throws Exception {
		c = new Customer();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCustomerId() {
			
			c.setCustomerId("0000000001");
		    String Customer_id = c.getCustomerId();
					
		assertEquals(Customer_id,"0000000001");
	}

	@Test
	public void testCustomerName() {
			
			c.setCustomerName("Sasidhran");
		    String Customer_name = c.getCustomerName();
					
		assertEquals(Customer_name,"Sasidhran");
	}
	
	@Test
	public void testLocation() {
			
			c.setLocation("UTN");
		    String location = c.getLocation();
					
		assertEquals(location,"UTN");
	}
	
	@Test
	public void testCustomerEmail() {
			
			c.setCustomer_email_id("sthuthik@uncc.edu");
		    String Customer_Email = c.getCustomer_email_id();
					
		assertEquals(Customer_Email,"sthuthik@uncc.edu");
	}
	
	@Test
	public void testCustomerPhone() {
			
			c.setCustomer_phone_no("7049572310");
		    String Customer_phone = c.getCustomer_phone_no();
					
		assertEquals(Customer_phone,"7049572310");
	}
	
	@Test
	public void testCustomerAdd() {
			
			c.setCustomer_address("University Terrace Drive");
		    String Customer_add = c.getCustomer_address();
					
		assertEquals(Customer_add,"University Terrace Drive");
	}
}
