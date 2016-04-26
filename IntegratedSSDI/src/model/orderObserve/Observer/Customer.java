package model.orderObserve.Observer;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import model.User;
import model.orderObserve.observable.IOrderData;
import model.orderObserve.observable.IProvideOrderData;
import util.db.connection.EmailUtility;

public class Customer  implements  User, IObserveOrder{
private IProvideOrderData provider ;
public String customerId;
public String customerName;
public String location;
public String customer_email_id;
public String customer_phone_no;
public String customer_address;
public Customer(IProvideOrderData p)
{
	provider = p ;
	provider.addSubscriber(this);
}
public Customer(String customerId,String customerName,String location,String customer_email_id,String customer_phone_no,String customer_address)
{
this.customerId=customerId;
this.customerName=customerName;
this.location=location;
this.customer_email_id=customer_email_id;
this.customer_phone_no=customer_phone_no;
this.customer_address=customer_address;
}
public String getCustomer_address() {
	return customer_address;
}
public String getCustomer_email_id() {
	return customer_email_id;
}
public String getCustomer_phone_no() {
	return customer_phone_no;
}
public String getCustomerId() {
	return customerId;
}
public String getCustomerName() {
	return customerName;
}
public String getLocation() {
	return location;
}
public void setCustomer_address(String customer_address) {
	this.customer_address = customer_address;
}
public void setCustomer_email_id(String customer_email_id) {
	this.customer_email_id = customer_email_id;
}
public void setCustomer_phone_no(String customer_phone_no) {
	this.customer_phone_no = customer_phone_no;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public void setLocation(String location) {
	this.location = location;
}
public Customer() {
	// TODO Auto-generated constructor stub
}
public RequestDispatcher directUser(HttpServletRequest request) {
	// TODO Auto-generated method stub
    RequestDispatcher r = request.getRequestDispatcher("/CustomerHome.jsp") ;
    return r;
}

public void notify(IOrderData o )
{   System.out.println("inside notuify");
	String curr_status = null,cust_email = null;
	int cust_id = 0 ;
	String query = "select order_status,customer_id   from  orderdetails where orderId = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11"); 
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1,o.getOrderId() );
			ResultSet rs=st.executeQuery();
			
			if (rs.next())
			{    curr_status  = rs.getString(1);
			     cust_id = rs.getInt(2);
			}
			query = "select customer_email_id from customer where customerId = ?";
			st= con.prepareStatement(query);
			st.setInt(1,cust_id );
		
		    rs=st.executeQuery();
			
			if (rs.next())
			{    cust_email  = rs.getString(1);
			     
			}
				 
			
			if (!curr_status.equals(o.getOrder_status()))
			{    System.out.println("i m here inside");
		
			String recipient  = cust_email;
			System.out.println("email"+recipient);
			
                 String subject = "Update regarding order "+o.getOrderId();
                 String content = null;
                 if (curr_status.equals("PickedUp"))
                 {
                 content = "Order id "+o.getOrderId()+ " is been servicing";
                 }
                 if (curr_status.equals("Placed")) 
                 {
                 content = "Order id "+o.getOrderId()+ " is picked up from your location and will be shortly serviced ";
                 }
                 if (curr_status.equals("Serviced")) 
                 {
                	 content = "Order id "+o.getOrderId()+ " has been serviced and will be deliverd soon ";
                 }
                 String resultMessage = "";
                
                try{
                	String host = "smtp.gmail.com";
                    String port = "587";
                    String user = "ssdiproj123@gmail.com";
                    String pass = "sss123!!";
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
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
}
}
