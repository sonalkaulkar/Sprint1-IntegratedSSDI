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

/**
 * Servlet implementation class AddStoreController
 */

public class AddStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	   private  RequestDispatcher rd = null;
	    private HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public AddStoreController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
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
	        	if(session == null){session=request.getSession(false);}  
		          
		              String username=(String)session.getAttribute("username");  
		                
		             // out.print("Hello, "+username); 
		              if(username!=null){    
	           String store_id = request.getParameter("store_id");
	           String store_name = request.getParameter("Store_Name");
	           String store_loc = request.getParameter("location");
	           String store_add = request.getParameter("Address");
	           String store_phone = request.getParameter("Phone");
	           String store_emailid = request.getParameter("email-id");
	         	
	           Store store = new Store(store_id,store_name,store_add,store_loc,store_phone,store_emailid);
	                
	                 System.out.println("inside");
	                 int flag = serviceDao.addStore(store);
	                 //RequestDispatcher rd = null;
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
		                 request.setAttribute("store_id",store_id);
		                 if(rd == null)
		                 {
		                	 rd=request.getRequestDispatcher("/StoreAdded.jsp");
		                	 rd.include(request, response);
		                 }
	                 }
	                 
	                
	                 
	            
	           
	    }  else{  
            //out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        } }catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
