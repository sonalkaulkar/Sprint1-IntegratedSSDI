package org.uncc.entities;
import org.uncc.exception.InvalidTestData;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidDataException;

import model.Login;


public class LoginTest {
	Login l;

	@Before
	public void setUp() throws Exception {
		l = new Login();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsername() {
			
			l.setUsername("Admin");
		    String Username = l.getUsername();
					
		assertEquals(Username,"Admin");
	}

	@Test
	public void testPassword() {
			
			l.setPassword("Admin");
		    String Password = l.getPassword();
					
		assertEquals(Password,"Admin");
	}
	@Test
	public void testRoleid() {
			
			l.setRoleid(1);
		    int role_id= l.getRoleid();
					
		assertEquals(role_id,1);
	}
}
