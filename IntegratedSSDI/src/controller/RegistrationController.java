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

import org.uncc.util.EmailUtility;

import model.Customer;
import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;
import model.deliveryStaff;
import model.technician;

/**
 * Servlet implementation class RegistrationController
 */

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	private String host;
    private String port;
    private String user;
    private String pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		ServletContext context = getServletContext();
  		host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
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
	            
	           System.out.println("inside registration controller");
	           PrintWriter out = response.getWriter();
	           RequestDispatcher rd = null;
	           
	           String customer_id = request.getParameter("customerId");//change these names as per jsp names
	           String customer_name = request.getParameter("customerName");
	           String location = request.getParameter("location");
	           String customer_email = request.getParameter("customer_email_id") ;
	           String customer_phone = request.getParameter("customer_phone_no");
	           String customer_add = request.getParameter("customer_add");
	           String customer_username = request.getParameter("customer_username");
	           String customer_password = request.getParameter("customer_password");
	           Customer cus = new Customer(customer_id,customer_name,location,customer_email,customer_phone,customer_add);
	                Login l = new Login(customer_username,customer_password,0);
	                 
	                 int flag = serviceDao.registration(cus,l);
	                 if (flag == 0)
	                 {   String recipient  = customer_email;
                     String subject = "Registered as customer ";
                     String content = "Your username is Cus"+customer_username;
                     String resultMessage = "";
                    try{
                     EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                             content);
                     resultMessage = "The e-mail was sent successfully";
                     System.out.println(resultMessage);
                 } 
                    catch (Exception ex) {
                     ex.printStackTrace();
                     resultMessage = "There were an error: " + ex.getMessage();
                     System.out.println(resultMessage);
                 } 
	                	 String str = "Registration Successful for Cus"+customer_username;
	                	 request.setAttribute("msg", str);
	                	
		                 rd=request.getRequestDispatcher("/RegistrationSuccess.jsp");
		                 rd.include(request, response); 
		                 
              
	                 }
	                
	                 if (flag == 2)
	                 	{System.out.println("here");
	                	 String str = "Email-id already registered";
	                	 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/RegistrationSuccess.jsp");  
		                 rd.include(request, response);  
	                 	}
	                   if (flag == 1)
		                 { 
	                	 String str = "Registration not successful";
	                	 System.out.println(str);
		                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/RegistrationSuccess.jsp");  
		                 rd.include(request, response);  
	                 }
	                 
	                           
	    }  catch (Exception ex) {
	    	System.out.println("Exception in registration controller");
	    	ex.printStackTrace();
	       }
	    }
	

	
}
