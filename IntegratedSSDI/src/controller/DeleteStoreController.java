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
 * Servlet implementation class UpdateStoreController
 */

public class  DeleteStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStoreController() {
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
	           String store_id = request.getParameter("storeId");
	          
	           Store store = new Store(store_id);
	           System.out.println("store id :"+store_id);
	                 System.out.println("inside");
	                 int flag = serviceDao.deleteStore(store);
	                 RequestDispatcher rd = null;
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
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
