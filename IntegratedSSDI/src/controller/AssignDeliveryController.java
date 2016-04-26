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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginController
 */

public class AssignDeliveryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignDeliveryController() {
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
	        PrintWriter out = response.getWriter();
	        try  {
	        	HttpSession session=request.getSession(false);  
		          
		        	  
		              String username=(String)session.getAttribute("username");
		              if(username!=null){    
		              String delid1= request.getParameter("deliveryid1");
		              String delid2=request.getParameter("deliveryid2");;
		                
		    System.out.println("inside transfer orders controller"+delid1);
	           
	        	  int flag=0;
	         
	          flag  = serviceDao.TransferOrdersTo(delid1,delid2);
	              
	              if (flag==0){
	            	  String str = "Orders transferred Successfully from "+delid1+" to "+delid2;
		                 request.setAttribute("msg", str);
	                 RequestDispatcher rd1=request.getRequestDispatcher("/OrdersTransferred.jsp");
	                   rd1.include(request, response);
	              }
	           
	     else{  
	    	System.out.println("unable to perform the requested action");
	    	RequestDispatcher rd1=request.getRequestDispatcher("/OrdersTransferred.jsp");
            rd1.include(request, response); 
        }
		              }
		              else
		              {
		            	  //out.print("Please login first");  
			              request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
		              }
 }catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
