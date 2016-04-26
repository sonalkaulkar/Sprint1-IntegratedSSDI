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
import model.deliveryStaff;
import model.technician;

/**
 * Servlet implementation class DeleteTechnicianController
 */

public class  DeleteDeliveryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    private  RequestDispatcher rd = null;
    private HttpSession session = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeliveryController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DeleteDeliveryController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
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
	        try  {
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	
	          PrintWriter out = response.getWriter();
	          HttpSession session=request.getSession(false);  
	          
        	  
              String username=(String)session.getAttribute("username");
              if(username!=null){    
	           String del_id = request.getParameter("delId");
	          
	           deliveryStaff delivery = new deliveryStaff(del_id);
	           System.out.println("del id :"+del_id);
	                 System.out.println("inside");
	                 int flag = serviceDao.deletedelivery(delivery);
	                 //RequestDispatcher rd = null;
	                 if (flag == 0)
	                 {  String str = "Delivery Staff  "+del_id+" deleted Successfully";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/DeleteDelivery.jsp");
	                 rd.include(request, response);  
	     
	                 }
	                 
	                 if (flag == 2)
	                 {  String str = "Delivery Staff  "+del_id+" has orders assigned to him ";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/DeleteDelivery.jsp");
	                 rd.include(request, response);  
	                 }
	                 if (flag == 1)
	                 {
	                	 String str = "Delivery Staff  "+del_id+" not deleted Successfully";
		                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/DeleteDelivery.jsp"); 
	                 rd.include(request, response); 
              
	                 }
              }
              else
              {
            	  out.print("Please login first");  
	              request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
              }
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
