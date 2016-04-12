package org.uncc.entities;
import org.uncc.exception.InvalidTestData;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidDataException;


import model.deliveryStaff;


public class DeliveryStaffTest {
	deliveryStaff d;

	@Before
	public void setUp() throws Exception {
		d = new deliveryStaff();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeliveryId() {
			
			d.setDeliveryId("0000000001");
		    String Delivery_id = d.getDeliveryId();
					
		assertEquals(Delivery_id,"0000000001");
	}

	@Test
	public void testDeliveryName() {
			
			d.setDeliveryName("Sasidhran");
		    String Delivery_name = d.getDeliveryName();
					
		assertEquals(Delivery_name,"Sasidhran");
	}
	
	@Test
	public void testLocation() {
			
			d.setLocation("UTN");
		    String location = d.getLocation();
					
		assertEquals(location,"UTN");
	}
	
	@Test
	public void testDeliveryEmail() {
			
			d.setDelivery_email_id("sthuthik@uncc.edu");
		    String Delivery_Email = d.getDelivery_email_id();
					
		assertEquals(Delivery_Email,"sthuthik@uncc.edu");
	}
	
	@Test
	public void testDeliveryPhone() {
			
			d.setDelivery_phone_no("7049572310");
		    String Delivery_phone = d.getDelivery_phone_no();
					
		assertEquals(Delivery_phone,"7049572310");
	}
	
	@Test
	public void testDeliveryAdd() {
			
			d.setDelivery_add("University Terrace Drive");
		    String Delivery_add = d.getDelivery_add();
					
		assertEquals(Delivery_add,"University Terrace Drive");
	}
	
	
}
