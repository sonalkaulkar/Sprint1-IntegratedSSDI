/**
    *
    * @author sadla
    */

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import model.Login;
import model.ServicesDao;
import model.ServicesDaoFactory;
import model.Store;
import model.User;
import model.UserFactory;
import model.technician;
import util.db.connection.EmailUtility;

/**
 * Servlet implementation class AddStoreController
 */

public class AddTechController extends HttpServlet {
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
    public AddTechController() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    public AddTechController(ServicesDao s,RequestDispatcher rd,HttpSession sess) {
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
	        PrintWriter out = response.getWriter();
	        try  {
	        	 session=request.getSession(false);  
		          
		              String username=(String)session.getAttribute("username");  
		              if(username!=null){    
		             // out.print("Hello, "+username);  
	           System.out.println("inside add technician controller");
	        //   PrintWriter out = response.getWriter();
	          // RequestDispatcher rd = null;
	           
	           String tech_id = request.getParameter("techId");//change these names as per jsp names
	           String tech_name = request.getParameter("techName");
	           String tech_phone = request.getParameter("tech_phone_no");
	           String tech_emailid = request.getParameter("tech_email_id");
	       //    String store_id = request.getParameter("store_id");
	           String username1 = request.getParameter("username1");
	           //java.sql.Timestamp t=convertStringToTimestamp(request.getParameter("lastcompletedtime"));
	           
	           java.util.Date utilDate = new java.util.Date();
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(utilDate);
	            cal.set(Calendar.MILLISECOND, 0);
	            java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
	          	           
	           technician tech = new technician(tech_id,tech_name,"free",0,tech_emailid,tech_phone,"",t);
	           Login L = new Login (username1,username1,0); 
	                 
	                 int flag = serviceDao.addTechnician(tech,L,username);
	                 if (flag == 0)
	                 {	String recipient  = tech_emailid;
                     String subject = "Registered as  technician";
                     String content = "Your username is Tec"+username1+" and password is the same as the username";
                     String resultMessage = "";
                    try{
                     EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                             content);
                     resultMessage = "The e-mail was sent successfully";
                     System.out.println(resultMessage);
                 } catch (Exception ex) {
                     ex.printStackTrace();
                     resultMessage = "There were an error: " + ex.getMessage();
                     System.out.println(resultMessage);
                 } 
	                	 String str = "Registration Successfully";
	                	 request.setAttribute("msg", str);
	                	 System.out.println(str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/technicianAdded.jsp");
		                 rd.include(request, response); 
              
	                 }
	                 if (flag == 2)
	                 	{
	                	 String str = "Email-id already registered";
	                	 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/technicianAdded.jsp");  
		                 rd.include(request, response);  
	                 	}
	                   if (flag == 1)
		                 { 
	                	 String str = "Technician staff not added";
	                	 System.out.println(str);
		                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
		                 rd=request.getRequestDispatcher("/technicianAdded.jsp");  
		                 rd.include(request, response);  
	                 }
	                
	                           
		          } else{  
		              //out.print("Please login first");  
		              request.getRequestDispatcher("InitialPage.jsp").include(request, response);  
		          }

		          }  catch (Exception ex) {
	    	System.out.println("Exception in addtech controller");
	    	ex.printStackTrace();
	       }
	    }
	
	   public java.sql.Timestamp convertStringToTimestamp(String str_date) throws java.text.ParseException {
		    try {
		      DateFormat formatter;
		      formatter = new SimpleDateFormat("dd/MM/yyyy");
		       // you can change format of date
		      java.util.Date date = formatter.parse(str_date);
		      java.sql.Timestamp timeStampDate = new java.sql.Timestamp(date.getTime());

		      return timeStampDate;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);
		      return null;
		    }
		  }
	
}
