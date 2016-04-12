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
import model.technician;

/**
 * Servlet implementation class DeleteTechnicianController
 */

public class  DeleteTechnicianController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDao serviceDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTechnicianController() {
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
	           String tech_id = request.getParameter("techId");
	          
	           technician technician = new technician(tech_id);
	           System.out.println("tech id :"+tech_id);
	                 System.out.println("inside");
	                 int flag = serviceDao.deleteTechnician(technician);
	                 RequestDispatcher rd = null;
	                 if (flag == 0)
	                 {  String str = "Technician "+tech_id+" deleted Successfully";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/DeleteTechnician.jsp");
	                 rd.include(request, response);  
	                 }
	                 if (flag == 2)
	                 {  String str = "Technician "+tech_id+" has orders assigned to him ";
	                 request.setAttribute("msg", str);
	                 rd=request.getRequestDispatcher("/DeleteTechnician.jsp");
	                 rd.include(request, response);  
	                 }
	                 
	                 if (flag == 1)
	                 {
	                	 String str = "Technician "+tech_id+" not deleted Successfully";
		                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/DeleteTechnician.jsp"); 
	                 rd.include(request, response); 
              
	                 }
	                
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

	
}
