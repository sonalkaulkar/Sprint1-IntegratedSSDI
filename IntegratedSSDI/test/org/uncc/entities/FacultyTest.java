/*package org.uncc.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uncc.exception.InvalidDataException;

public class FacultyTest {
	Faculty faculty;

	@Before
	public void setUp() throws Exception {
		faculty = new Faculty();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidEmail() {
		boolean exception_caught = false;
		try {
			faculty.setEmail("hramapra@uncc.edu");
		} catch (InvalidDataException ex) {
			exception_caught = true;
		}
		assertFalse(exception_caught);
	}

	@Test
	public void testInvalidEmail() {
		boolean exception_caught = false;
		try {
			faculty.setEmail("Invalid email string");
		} catch (InvalidDataException ex) {
			exception_caught = true;
		}
		assertTrue(exception_caught);
	}
}
*/