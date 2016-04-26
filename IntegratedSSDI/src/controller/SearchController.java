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

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		             // out.print("Hello, "+username); 
	        	System.out.println("inside view stores controller");
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	 //String custId = request.getParameter("CustomerId");
	        	 String product = request.getParameter("Product");
	        	 String company = request.getParameter("Company");
	        	 String location = request.getParameter("location");
	        	 System.out.println(product + company + location );
	        	 product p =  new product("",product,company);
	        	  ArrayList<Store> slist = new ArrayList();
	        //  PrintWriter out = response.getWriter();
	          slist  = serviceDao.searchStores(p,location);
	                 RequestDispatcher rd = null;
	                 request.setAttribute("product", product);
	                 request.setAttribute("company", company);
	                 request.setAttribute("location", location);
	               //  request.setAttribute("custId", custId);
	                 request.setAttribute("store", slist);
	                 RequestDispatcher rd1=request.getRequestDispatcher("/SelectStore.jsp");
	                   rd1.include(request, response);
	           
		          }
		          else{  
		              out.print("Please login first");  
		              request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
		          }
}  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
