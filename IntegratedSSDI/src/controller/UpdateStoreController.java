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

public class  UpdateStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;

	   private  RequestDispatcher rd = null;
	    private HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UpdateStoreController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
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
//	          PrintWriter out = response.getWriter();
	           String store_id = request.getParameter("storeId");
	           String store_name = request.getParameter("StoreName");
	           String store_loc = request.getParameter("StoreLocation");
	           String store_add = request.getParameter("storeAdd");
	           String store_phone = request.getParameter("store_phone_no");
	           String store_emailid = request.getParameter("store_email_id");
	          
	           Store store = new Store(store_id,store_name,store_add,store_loc,store_phone,store_emailid,"","","","");
	                
	                 System.out.println("inside");
	                 int flag = serviceDao.updateStore(store);
	                 //RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {    request.setAttribute("store_id",store_id);
	                	 String str = "Store "+store_id+" not updated Successfully";
		                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/UpdateStore.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 0)
	                 {  String str = "Store "+store_id+" updated  Successfully";
	                 request.setAttribute("msg", str);
	                 request.setAttribute("store_id",store_id);
	                 rd=request.getRequestDispatcher("/UpdateStore.jsp");
	                 rd.include(request, response);  
	                 }

	              }
	              else
	              {
	            	  out.print("Please login first");  
                      request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
                  
	              }
	    }
	        catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
