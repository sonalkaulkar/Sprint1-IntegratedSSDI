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

import model.Customer;
import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;

/**
 * Servlet implementation class ManageProfileController
 */

public class  ManageProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProfileController() {
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
	           String customer_id = request.getParameter("customerId");
	           String customer_name = request.getParameter("customerName");
	           String customer_loc = request.getParameter("location");
	           String customer_emailid = request.getParameter("customer_email_id");
	           String customer_phone = request.getParameter("customer_phone_no");
	           String customer_add = request.getParameter("customer_add");
	          System.out.println("contr"+customer_add);
	           Customer customer = new Customer(customer_id,customer_name,customer_loc,customer_emailid,customer_phone,customer_add);
	                
	                 System.out.println("inside");
	                 int flag = serviceDao.updateCustomer(customer);
	                 RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {
	                	 String str = "Profile  not updated Successfully";
		                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/CusProfileUpdated.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 0)
	                 {  String str = "Profile updated  Successfully";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/CusProfileUpdated.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
