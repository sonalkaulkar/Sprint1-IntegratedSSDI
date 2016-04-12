package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;
import model.product;

/**
 * Servlet implementation class AddStoreController
 */

public class NewRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequestController() {
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
		          if(session!=null){  
		              String username=(String)session.getAttribute("username");  
		                
		            //  out.print("Hello, "+username); 
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	
//	          PrintWriter out = response.getWriter();
	           String product = request.getParameter("product");
	           String company = request.getParameter("company");
	           String location = request.getParameter("location");
	          // int  cust_id = Integer.parseInt(request.getParameter("custId"));
	           String   store_id = request.getParameter("storeId");
	           String description = request.getParameter("description");
	           System.out.println(product+company+location);
	           product p = new  product("",product,company);
	           Store store = new Store(store_id);
	                
	                 System.out.println("inside");
	                 int order_id = serviceDao.newRequest(store,p,location,description,username);
	                 RequestDispatcher rd = null;
	                 if (order_id != 0)
	                 {String str = "Request with request id "+order_id+" has been placed ";
	                 request.setAttribute("msg",str); 
	           	    // out.print("Store not added successfully ");
	                 rd=request.getRequestDispatcher("/RequestAdded.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (order_id == 0)
	                 {  //out.print("Store added Successfully");
	                	 String str = " Request not added  ";
		                 request.setAttribute("msg",str); 
	                 rd=request.getRequestDispatcher("/RequestAdded.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    } else{  
            out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        }
 } catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
