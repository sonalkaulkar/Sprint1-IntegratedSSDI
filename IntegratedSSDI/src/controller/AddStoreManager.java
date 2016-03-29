/**
    *
    * @author sadla
    */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;
import model.deliveryStaff;
import model.technician;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * Servlet implementation class AddStoreController
 */

public class AddStoreManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreManager() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		ServletContext context = getServletContext();
  		ServicesDaoFactory factory = ServicesDaoFactory.getInstance(context.getInitParameter("environment"));
  		 serviceDao = factory.createServiceDao();
  	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try  {
	            
	           System.out.println("inside add storemanager controller");
	           PrintWriter out = response.getWriter();
	           RequestDispatcher rd = null;
	           String store_id = request.getParameter("store_id");
	           String manager_username = request.getParameter("username");
	           String manager = request.getParameter("manager");//change these names as per jsp names
	           String manager_phone = request.getParameter("manager_phone_no");
	           String manager_email = request.getParameter("manager_email_id");
	          	           System.out.println("hiiiiiiii"+store_id);
	           //deliveryStaff DStaff = new deliveryStaff(delivery_id,delivery_name,location,deliv_email,deliv_phone,store_id,deliv_add);
	            Store s=new Store(store_id);
	            s.setManager(manager);
	            s.setManager_Email_Id(manager_email);
	            s.setManager_Phone_No(manager_phone);
	            s.setManager_Username(manager_username);
	                 
	                 int flag = serviceDao.AddStoreManager(s);
	                 if (flag == 0)
	                 {   String to = manager_email;
	                 
	                 // Sender's email ID needs to be mentioned
	                 String from = "sonalkaulkar@gmail.com";
	            
	                 // Assuming you are sending email from localhost
	                 String host = "localhost";
	            
	                 // Get system properties
	                 Properties properties = System.getProperties();
	            
	                 // Setup mail server
	                 properties.setProperty("mail.smtp.host", host);
	                 properties.setProperty("mail.smtp.port", "8080");

	                 // Get the default Session object.
	                 Session session = Session.getDefaultInstance(properties);
	                 
	           	  // Set response content type
	                 response.setContentType("text/html");
	                // PrintWriter out = response.getWriter();

	                 try{
	                    // Create a default MimeMessage object.
	                    MimeMessage message = new MimeMessage(session);
	                    // Set From: header field of the header.
	                    message.setFrom(new InternetAddress(from));
	                    // Set To: header field of the header.
	                    message.addRecipient(Message.RecipientType.TO,
	                                             new InternetAddress(to));
	                    // Set Subject: header field
	                    message.setSubject("Registered as store manager");
	                    // Now set the actual message
	                    message.setText("Your username is "+manager_username+"and password is the same");
	                    // Send message
	                    Transport.send(message);
	                    String title = "Send Email";
	                    String res = "Sent message successfully....";
	                    
	                 }catch (MessagingException mex) {
	                    mex.printStackTrace();
	                 }
	                	 String str = "Registration Successful";
	                	 System.out.println(str);
		                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/ManagerAdded.jsp");
		                 rd.include(request, response); 
              
	                 }
	                   if (flag == 2)
	                 	{
	                	 String str = "Email-id already registered";
	                	 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/ManagerAdded.jsp");  
		                 rd.include(request, response);  
	                 	}
	                   if (flag == 1)
		                 { 
	                	 String str = "Manager details failed to change";
	                	 System.out.println(str);
		                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/ManagerAdded.jsp");  
		                 rd.include(request, response);  
	                 }
	                 
	                           
	    }  catch (Exception ex) {
	    	System.out.println("Exception in addtech controller");
	    	ex.printStackTrace();
	       }
	    }
	

	
}
