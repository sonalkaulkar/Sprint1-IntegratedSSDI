package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

public class  UpdateClosedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClosedController() {
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
	        HttpSession session=request.getSession(false); 
	        try  {
	        		
	        	  
		              String username=(String)session.getAttribute("username");
		              if(username!=null){
	            ArrayList<Integer> orders = new ArrayList<Integer>();
	        	String[] selectedOrders = request.getParameterValues("selectedItems");
	        	for (String selectedItem : selectedOrders) {
	        	    int order = Integer.parseInt(request.getParameter("order_" + selectedItem));
	        	    orders.add(order);
	        	    
	        	}
	                 System.out.println("inside");
	                 int flag = serviceDao.updateClosed(orders,username);
	                 RequestDispatcher rd = null;
	                 if (flag != 0)
	                 {    //request.setAttribute("",store_id);
	                	 String str = " Orders status  not updated Successfully";
		                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/UpdateClosed.jsp");  
	                 rd.include(request, response); 
              
	                 }
	                 if (flag == 0)
	                 {  String str = "Orders  status updated Successfully";
	                 request.setAttribute("msg", str);
	                 
	                 rd=request.getRequestDispatcher("/UpdateClosed.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                
	        	  }

	                 else{  
	                            out.print("Please login first");  
	                            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
	                        }

	           
	    }
	        catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
