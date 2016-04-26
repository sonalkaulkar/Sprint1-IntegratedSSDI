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

public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	private HttpSession  session = null;
	  private  RequestDispatcher rd = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public AddProductController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
        super();
        serviceDao = s;
        this.rd = rd;
        session = sess;
        
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
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	if (session == null){session=request.getSession(false);}  
	      
		              String username=(String)session.getAttribute("username");  
		              if(username!=null){    
		             // System.out.print("Hello, "+username); 	
	          
	           int store_id = Integer.parseInt(request.getParameter("store_id"));
	           String product_name = request.getParameter("Product_Name");
	           String company_name = request.getParameter("Company_Name");
	      
	         	
	           product  p = new product("",product_name,company_name);
	                
	                 System.out.println("inside");
	                 int flag = serviceDao.addProduct(p,store_id);
	                 
	                 if (flag == 1)
	                 {String str = "Invalid combination of product and company ";
	                 request.setAttribute("msg",str); 
	                 request.setAttribute("store_id",store_id); 
	           	    // out.print("Store not added successfully ");
	                 
	                 rd=request.getRequestDispatcher("/ProductAdded.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 2)
	                 {String str = "Product already registered for this store ";
	                 request.setAttribute("msg",str); 
	                 request.setAttribute("store_id",store_id); 
	           	    // out.print("Store not added successfully ");
	                 rd=request.getRequestDispatcher("/ProductAdded.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 3)
	                 {  //out.print("Store added Successfully");
	                	 String str = " Product not  added ";
		                 request.setAttribute("msg",str); 
		                 request.setAttribute("store_id",store_id);     
	                 rd=request.getRequestDispatcher("/ProductAdded.jsp");
	                 rd.include(request, response);  
	                 }
	                 if (flag == 0)
	                 {  //out.print("Store added Successfully");
	                	 String str = " Product   added  successful";
		                 request.setAttribute("msg",str); 
		                 request.setAttribute("store_id",store_id);
		                 
		                	 rd=request.getRequestDispatcher("/ProductAdded.jsp");
		                	 rd.include(request, response);  
		                 
	                 }

	                 
	                
	                 
	            
	           
	    } else{  
            //out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        }}  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
