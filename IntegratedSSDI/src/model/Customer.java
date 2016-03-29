package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class Customer  implements  User{
public String customerId;
public String customerName;
public String location;
public String customer_email_id;
public String customer_phone_no;
public String customer_address;
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
    RequestDispatcher r = request.getRequestDispatcher("/Customerhome.jsp") ;
    return r;
}
}
