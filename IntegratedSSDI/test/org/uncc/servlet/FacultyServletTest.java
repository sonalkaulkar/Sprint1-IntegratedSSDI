/*package org.uncc.servlet;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.uncc.dao.FacultyDao;
import org.uncc.entities.Faculty;

public class FacultyServletTest extends Mockito {

	@InjectMocks
	private FacultyServlet facultyServlet;

	@Mock
	FacultyDao facultyDao;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() throws Exception {

		Faculty faculty1 = new Faculty();
		faculty1.setEmail("varda@uncc.edu");
		Faculty faculty2 = new Faculty();
		faculty2.setEmail("chaitanya@uncc.edu");

		List<Faculty> faculties = new ArrayList<Faculty>();
		faculties.add(faculty1);
		faculties.add(faculty2);

		when(facultyDao.getFaculties()).thenReturn(faculties);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);

		facultyServlet.doGet(request, response);

		verify(facultyDao, times(1)).getFaculties();
		verifyNoMoreInteractions(facultyDao);

		writer.flush();
		assertEquals(
				"[{\"email\":\"varda@uncc.edu\"},{\"email\":\"chaitanya@uncc.edu\"}]",
				new String(output.toByteArray(), "UTF-8"));
	}
}*/