/**
    *
    * @author sadla
    */
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
import model.deliveryStaff;
import model.technician;

/**
 * Servlet implementation class AddStoreController
 */

public class AddDeliveryStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeliveryStaff() {
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
	            
	           System.out.println("inside add delivery staff controller");
	           PrintWriter out = response.getWriter();
	           RequestDispatcher rd = null;
	           
	           String delivery_id = request.getParameter("deliveryId");//change these names as per jsp names
	           String delivery_name = request.getParameter("deliveryName");
	           String location = request.getParameter("location");
	           String deliv_email = request.getParameter("delivery_email_id") ;
	           String deliv_phone = request.getParameter("delivery_phone_no");
	           String store_id = request.getParameter("store_id");
	           String deliv_add = request.getParameter("delivery_add");
	           String username = request.getParameter("username");
	           deliveryStaff DStaff = new deliveryStaff(delivery_id,delivery_name,location,deliv_email,deliv_phone,store_id,deliv_add);
	                Login l = new Login(username,username);
	                 
	                 int flag = serviceDao.addDeliveryStaff(DStaff,l);
	                 if (flag == 0)
	                 {
	                	 String str = "Registration Successful";
	                	 request.setAttribute("msg", str);
	                	
		                 rd=request.getRequestDispatcher("/DeliveryAdded.jsp");
		                 rd.include(request, response); 
              
	                 }
	                
	                 if (flag == 2)
	                 	{System.out.println("here");
	                	 String str = "Email-id already registered";
	                	 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/DeliveryAdded.jsp");  
		                 rd.include(request, response);  
	                 	}
	                   if (flag == 1)
		                 { 
	                	 String str = "Delivery staff not added";
	                	 System.out.println(str);
		                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/DeliveryAdded.jsp");  
		                 rd.include(request, response);  
	                 }
	                 
	                           
	    }  catch (Exception ex) {
	    	System.out.println("Exception in addtech controller");
	    	ex.printStackTrace();
	       }
	    }
	

	
}
