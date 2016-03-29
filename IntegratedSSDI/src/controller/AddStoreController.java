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

import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;

/**
 * Servlet implementation class AddStoreController
 */

public class AddStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreController() {
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
	           String store_id = request.getParameter("store_id");
	           String store_name = request.getParameter("Store_Name");
	           String store_loc = request.getParameter("location");
	           String store_add = request.getParameter("Address");
	           String store_phone = request.getParameter("Phone");
	           String store_emailid = request.getParameter("email-id");
	         	
	           Store store = new Store(store_id,store_name,store_add,store_loc,store_phone,store_emailid);
	                
	                 System.out.println("inside");
	                 int flag = serviceDao.addStore(store);
	                 RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {String str = "Store not added successfully ";
	                 request.setAttribute("msg",str); 
	           	    // out.print("Store not added successfully ");
	                 rd=request.getRequestDispatcher("/StoreAdded.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 0)
	                 {  //out.print("Store added Successfully");
	                	 String str = " New Store added successfully ";
		                 request.setAttribute("msg",str); 
	                 rd=request.getRequestDispatcher("/StoreAdded.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
