package org.uncc.entities;
import org.uncc.exception.InvalidTestData;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidDataException;

import model.technician;


public class TechnicianTest {
	technician t;

	@Before
	public void setUp() throws Exception {
		t = new technician();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTechnicianId() {
			
			t.setTechId("0000000001");
		    String Technician_id = t.getTechId();
					
		assertEquals(Technician_id,"0000000001");
	}

	@Test
	public void testTechnicianName() {
			
			t.setTechName("Sasidhran");
		    String Technician_name = t.getTechName();
					
		assertEquals(Technician_name,"Sasidhran");
	}
	
	@Test
	public void testTechnicianStatus() {
			
			t.setTechStatus("Free");
		    String Technician_status = t.getTechStatus();
					
		assertEquals(Technician_status,"Free");
	}
	
	@Test
	public void testNoOfOrders() {
			
			t.setNo_of_orders(2);
		    int No_of_orders = t.getNo_of_orders();
					
		assertEquals(No_of_orders,2);
	}
	
	@Test
	public void testTechnicianPhone() {
			
			t.setTech_phone_no("7049572310");
		    String Technician_phone = t.getTech_phone_no();
					
		assertEquals(Technician_phone,"7049572310");
	}
	
	@Test
	public void testTechnicianEmail() {
			
			t.setTech_email_id("sthuthik@uncc.edu");
		    String Technician_email = t.getTech_email_id();
					
		assertEquals(Technician_email,"sthuthik@uncc.edu");
	}
	
	@Test
	public void testStoreId() {
			
			t.setStore_id("0000000001");
		    String Store_id = t.getStore_id() ;
					
		assertEquals(Store_id,"0000000001");
	}
	
	@Test
	public void LastCompletedTimestamp() {
		 java.util.Date utilDate = new java.util.Date();
         Calendar cal = Calendar.getInstance();
         cal.setTime(utilDate);
         cal.set(Calendar.MILLISECOND, 0);
         java.sql.Timestamp t1 = new java.sql.Timestamp(utilDate.getTime()); 
		
			t.setLast_completed_timestamp(t1);
		    Timestamp Last_time = t.getLast_completed_timestamp();
					
		assertEquals(Last_time,t1);
	}
}
