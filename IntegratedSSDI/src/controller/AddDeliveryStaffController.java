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
import javax.servlet.http.HttpSession;

import org.uncc.util.EmailUtility;

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

public class AddDeliveryStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
	private String host;
    private String port;
    private String user;
    private String pass;
    private  RequestDispatcher rd = null;
    private HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeliveryStaffController() {
        super();

    }

    public AddDeliveryStaffController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
        super();
        serviceDao = s;
        this.rd = rd;
        session = sess;
        
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
	            
	           System.out.println("inside add delivery staff controller");
	           PrintWriter out = response.getWriter();
	         
	            session=request.getSession(false); 
		          if(session!=null){  
		              String username=(String)session.getAttribute("username");  
		                
		         //     out.print("Hello, "+username);  
	          
	           String delivery_user = request.getParameter("delusername");
	           String delivery_id = request.getParameter("deliveryId");//change these names as per jsp names
	           String delivery_name = request.getParameter("deliveryName");
	           String location = request.getParameter("location");
	           String deliv_email = request.getParameter("delivery_email_id") ;
	           String deliv_phone = request.getParameter("delivery_phone_no");
	           //String store_id = request.getParameter("store_id");
	           String deliv_add = request.getParameter("delivery_add");
	           //String username = request.getParameter("username");
	           deliveryStaff DStaff = new deliveryStaff(delivery_id,delivery_name,location,deliv_email,deliv_phone,"",deliv_add,0);
	                Login l = new Login(delivery_user,delivery_user,0);
	                 
	                 int flag = serviceDao.addDeliveryStaff(DStaff,l,username);
	                 if (flag == 0)
	                 {   String recipient  = deliv_email;
                     String subject = "Registered as delivery staff";
                     String content = "Your username is Del"+username+" and password is the same as the username";
                     String resultMessage = "";
                     String str = "Registration Successful";
                	 request.setAttribute("msg", str);
                     if (rd == null)
	                	{
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
	                	 
	                	
		                 rd=request.getRequestDispatcher("/DeliveryAdded.jsp");
		                 rd.include(request, response); 
	                	}
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
	                 
	                           
	    }   else{  
            out.print("Please login first");  
            request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
        }  }catch (Exception ex) {
	    	System.out.println("Exception in addtech controller");
	    	ex.printStackTrace();
	       }
	    }
	

	
}
