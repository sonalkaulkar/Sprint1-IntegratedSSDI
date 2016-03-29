package controller;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import model.*;
import sun.util.logging.PlatformLogger.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginController
 */

public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
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
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	int flag;
	          PrintWriter out = response.getWriter();
	           String old_password = request.getParameter("old_password");
	           String new_password = request.getParameter("new_password");
	           String confirm_password = request.getParameter("confirm_password");
	           RequestDispatcher rd = null;    
	           if (old_password.equals(new_password))
	         	    {
	         	    	 String str = "Password cannot be same as before .Please enter a new password";
		                 request.setAttribute("msg",str); 
	         
		           	 rd = request.getRequestDispatcher("/PasswordReset.jsp") ;
		           	rd.include(request, response); 
	         	    }
	           else if (!new_password.equals(confirm_password))
	         		   
	         	    {
	         		  String str = "New and confirm password should match";
		                 request.setAttribute("msg",str); 
	         
		           	 rd = request.getRequestDispatcher("/PasswordReset.jsp") ;
		           	rd.include(request, response); 
	         	    }
	           else
	        	   {Login l = new Login("", old_password);
	                
	                 System.out.println("inside");
	                 flag = serviceDao.updatePassword(l,new_password);
	                
	                 if (flag != 0)
	                 {System.out.println(" not found");
	               	 String str = "Password not  reset successfully ";
	                 request.setAttribute("msg",str); 
         
	           	 rd = request.getRequestDispatcher("/PasswordReset.jsp") ;
	           	rd.include(request, response); 
	                 }
	                 if (flag == 0)
	                 {  System.out.println("found");
	               	 String str = "Password  reset successfully";
	                 request.setAttribute("msg",str); 
         
		           	 rd = request.getRequestDispatcher("/PasswordReset.jsp") ;
	                 rd.include(request, response);  
	                 }
	                 
	                
	        	   } 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
