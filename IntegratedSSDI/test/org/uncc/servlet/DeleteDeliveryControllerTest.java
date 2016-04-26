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

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.junit.Before;
import org.mockito.*;

import controller.AddDeliveryStaffController;
import controller.AddStoreManagerController;
import controller.DeleteDeliveryController;
import controller.logincontroller;
import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import util.db.connection.EmailUtility;

public class DeleteDeliveryControllerTest extends Mockito {

// private EmailUtility eu ;
//   private static final Object EmailUtility = null;

	/** Servlet under test. */
    private DeleteDeliveryController servlet;

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
        servlet =  new DeleteDeliveryController(serviceDao,rd,session);
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
    @Test
    public void testDeleteDelivery() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
    	 when(serviceDao.deletedelivery(anyObject())).thenReturn(0);
        parameters.put("delId", "1");
      
   
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Delivery Staff  1 deleted Successfully", message);
    }

    /**
     * Test method for
     * {@link SessionServlet#doGet(HttpServletRequest, HttpServletResponse)} .
     *
     * @throws IOException
     * @throws ServletException
     */
    @Test
    public void testInvalidDeleteDelivery() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
   	 when(serviceDao.deletedelivery(anyObject())).thenReturn(1);
     parameters.put("delId", "1");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Delivery Staff  1 not deleted Successfully", message);
    }

    
    @Test
    public void testInvalidAssignedDeleteDelivery() throws ServletException, IOException {
    	//Login l = new Login("admin","admin",0);
   	 when(serviceDao.deletedelivery(anyObject())).thenReturn(2);
     parameters.put("delId", "1");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
		when(response.getWriter()).thenReturn(writer);
        servlet.doGet(request, response);

        Object object = attributes.get("msg");

       assertNotNull(object);
         assertTrue(String.class.isAssignableFrom(object.getClass()));

        String message = (String) object;
        System.out.println(message);
        assertEquals("Delivery Staff  1 has orders assigned to him ", message);
    }


}