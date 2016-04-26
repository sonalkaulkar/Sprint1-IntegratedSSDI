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

import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;
import model.deliveryStaff;
import model.technician;
import util.db.connection.EmailUtility;

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

public class AddStoreManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	private String host;
    private String port;
    private String user;
    private String pass;
    private  RequestDispatcher rd = null;
    private HttpSession session = null;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AddStoreManagerController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
        super();
        serviceDao = s;
        this.rd = rd;
        session = sess;
        
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		ServletContext context = getServletContext();
  		 host = context.getInitParameter("host");
         port = context.getInitParameter("port");
         user = context.getInitParameter("user");
         pass = context.getInitParameter("pass");
  		ServicesDaoFactory factory = ServicesDaoFactory.getInstance(context.getInitParameter("environment"));
  		 serviceDao = factory.createServiceDao();
  	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        PrintWriter out = response.getWriter();
	        try  {
	        	 session=request.getSession(false);  
		           
		              String username=(String)session.getAttribute("username");  
		              if(username!=null){    
		              //out.print("Hello, "+username); 
	           System.out.println("inside add storemanager controller");
	       
	           //RequestDispatcher rd = null;
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
	                 {   String recipient  = manager_email;
	                     String subject = "Registered as store manager";
	                     String content = "Your username is Str"+manager_username+" and password is the same";
	                     String resultMessage = "";
	                    try{
	                     EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
	                             content);
	                     resultMessage = "The e-mail was sent successfully";
	                     System.out.println(resultMessage);
	                 } catch (Exception ex) {
	                     ex.printStackTrace();
	                     resultMessage = "There were an error: " + ex.getMessage();
	                     System.out.println(resultMessage);
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
	                 
	                           
	    }   else{  
            //out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        }}catch (Exception ex) {
	    	System.out.println("Exception in addtech controller");
	    	ex.printStackTrace();
	       }
	    }
	

	
}
