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
 * Servlet implementation class UpdateStoreController
 */

public class  DeleteStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	private  RequestDispatcher rd = null;
    private HttpSession session = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DeleteStoreController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
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
	        	HttpSession session=request.getSession(false);  
		          
		              String username=(String)session.getAttribute("username");  
		              if(username!=null){   
		              //out.print("Hello, "+username); 
//	          PrintWriter out = response.getWriter();
	           String store_id = request.getParameter("storeId");
	          
	           Store store = new Store(store_id);
	           System.out.println("store id :"+store_id);
	                 System.out.println("inside");
	                 int flag = serviceDao.deleteStore(store);
	                 //RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {
	                	 String str = "Store "+store_id+" not deleted Successfully";
		                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/deleteStore.jsp"); 
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 0)
	                 {  String str = "Store "+store_id+" deleted Successfully";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/deleteStore.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    }   else{  
            //out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        }
}catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
