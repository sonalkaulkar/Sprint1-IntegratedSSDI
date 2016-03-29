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

public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
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
	        	
	          PrintWriter out = response.getWriter();
	           String username = request.getParameter("username");
	           String password = request.getParameter("password");
	         	
	                 Login l = new Login(username, password);
	                
	                 System.out.println("inside login controller");
	                 int flag = serviceDao.checkLogin(l);
	                 RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {
	                	 System.out.println(" not found");
	           	  //out.print("Invalid Username or password ");
	                	 request.setAttribute("msg", "Invalid Username or Password");
	           	 rd = request.getRequestDispatcher("/index1.jsp") ;
	           	rd.include(request, response); 
                         //      errorMsgs.clear();
           //  errorMsgs.add("Username already taken");
             //request.getSession().setAttribute("error",errorMsgs);
             
             
	                 }
	                 if (flag == 0)
	                 {  System.out.println("found");
	                // errorMsgs.clear();
	                 //request.setAttribute("ErrorMsgs",errorMsgs);
	                
	                 
	                 request.setAttribute("msg", "");
	                 UserFactory uf = new UserFactory();
	                 User u = uf.getUser(username.substring(0, 3));
	                 rd =   u.directUser(request);
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
