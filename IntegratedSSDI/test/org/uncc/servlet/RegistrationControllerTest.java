package org.uncc.servlet;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.uncc.dao.ServicesDaoTest;

import controller.RegistrationController;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.junit.Before;
import org.mockito.*;


import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import util.db.connection.EmailUtility;

public class RegistrationControllerTest extends Mockito {

// private EmailUtility eu ;
//   private static final Object EmailUtility = null;

	/** Servlet under test. */
    private RegistrationController servlet;

    /** Mock request. */
    private HttpServletRequest request;

    /** Mock response. */
    private HttpServletResponse response;

    /** Mock session. */
    private HttpSession session;

    /** Session's attribute map. */
    private Map attributes;

    /** Request's parameter map. */
    private Map parameters;
    

    /**
     * Launches Mockito configuration from annotations.
     */
    
    private RequestDispatcher rd;
    private ServicesDao serviceDao;
    @Before
    public void setUp() throws ServletException, IOException, AddressException, MessagingException {
  //      eu    	= mock(EmailUtility.class);

    	rd = mock(RequestDispatcher.class);
        attributes = new HashMap();
        parameters = new HashMap();
        serviceDao = mock(ServicesDao.class);
        session = mock(HttpSession.class);
        servlet =  new RegistrationController(serviceDao,rd,session);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
       
        
        //when(serviceDao.checkLogin(anyObject())).thenReturn(0);
        when(request.getSession(false)).thenReturn(session);
        when(request.getParameterMap()).thenReturn(parameters);
        when(request.getRequestDispatcher(anyString())).thenAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

                

                return rd;
            }
        });

        when(request.getParameter(anyString())).thenAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

                String key = (String) aInvocation.getArguments()[0];

                return parameters.get(key);
            }
        });

        when(session.getAttribute(anyString())).thenAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

                String key = (String) aInvocation.getArguments()[0];

                return attributes.get(key);
            }
        });

        Mockito.doAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

                String key = (String) aInvocation.getArguments()[0];
                Object value = aInvocation.getArguments()[1];
                attributes.put(key, value);

                return null;
            }

        }).when(session).setAttribute(anyString(), anyObject());
      
        
     /*   Mockito.doAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
           /* @Override
            /*public Object answer(InvocationOnMock aInvocation) throws Throwable {

               
                return "";
            }

        }).when	(EmailUtility.class).);*/
      
        Mockito.doAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

                String key = (String) aInvocation.getArguments()[0];
                Object value = aInvocation.getArguments()[1];
                attributes.put(key, value);

                return null;
            }

        }).when(request).setAttribute(anyString(), anyObject());
        
        Mockito.doAnswer(new Answer() {

            /**
             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
             */
            @Override
            public Object answer(InvocationOnMock aInvocation) throws Throwable {

             

                return "";
            }

        }).when(rd).include(anyObject(), anyObject());
       // ServicesDaoFactory factory = ServicesDaoFactory.getInstance("test");
		 //serviceDao = factory.createServiceDao();

    }
    

    /**
     * Test method for
     * {@link SessionServlet#doGet(HttpServletRequest, HttpServletResponse)} .
     *
     * @throws IOException
     * @throws ServletException
     */
    

    /**
     * Test method for
     * {@link SessionServlet#doGet(HttpServletRequest, HttpServletResponse)} .
     *
     * @throws IOException
     * @throws ServletException
     */
    @Test
    public void testInvalidRegistration() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
    	when(serviceDao.registration(anyObject(),anyObject())).thenReturn(1);
   	 parameters.put("customerId", "1");
     parameters.put("customerName", "sonal");
     parameters.put("location", "UT");
     parameters.put("customer_email_id", "sonal@gmail.com");
     parameters.put("customer_phone_no", "1234567890");
     parameters.put("customer_add", "ut north");
     parameters.put("customer_username", "sonal");
     parameters.put("customer_password", "sonal");
     
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Registration not successful", message);
    }

    
    @Test
    public void testInvalidEmailId() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
    	when(serviceDao.registration(anyObject(),anyObject())).thenReturn(2);
      	 parameters.put("customerId", "1");
        parameters.put("customerName", "sonal");
        parameters.put("location", "UT");
        parameters.put("customer_email_id", "sonal@gmail.com");
        parameters.put("customer_phone_no", "1234567890");
        parameters.put("customer_add", "ut north");
        parameters.put("customer_username", "sonal");
        parameters.put("customer_password", "sonal");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Email-id already registered", message);
    }
    @Test
    public void testRegistration() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
    	 when(serviceDao.registration(anyObject(),anyObject())).thenReturn(0);
        parameters.put("customerId", "1");
        parameters.put("customerName", "sonal");
        parameters.put("location", "UT");
        parameters.put("customer_email_id", "sonal@gmail.com");
        parameters.put("customer_phone_no", "1234567890");
        parameters.put("customer_add", "ut north");
        parameters.put("customer_username", "sonal");
        parameters.put("customer_password", "sonal");
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Registration Successful for Cussonal", message);
    }

}