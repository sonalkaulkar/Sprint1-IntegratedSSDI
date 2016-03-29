package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class deliveryStaff implements  User {
public String deliveryId;
public String deliveryName;
public String location;
public String delivery_email_id;
public String delivery_phone_no;
public String store_Id;
public String delivery_add;
public deliveryStaff() {
	// TODO Auto-generated constructor stub
}
public deliveryStaff(String deliveryId,String deliveryName,String location,String delivery_email_id,
		String delivery_phone_no,String store_Id,String delivery_add)
{
this.deliveryId=deliveryId;
this.deliveryName=deliveryName;
this.location=location;
this.delivery_email_id=delivery_email_id;
this.delivery_phone_no=delivery_phone_no;
this.store_Id=store_Id;
this.delivery_add=delivery_add;
}

 public String getDelivery_add() {
	return delivery_add;
}
 public String getDelivery_email_id() {
	return delivery_email_id;
}
 public String getDelivery_phone_no() {
	return delivery_phone_no;
}
 public String getDeliveryId() {
	return deliveryId;
}
 public String getDeliveryName() {
	return deliveryName;
}
 public String getLocation() {
	return location;
}
 public String getStore_Id() {
	return store_Id;
}
 public void setDelivery_add(String delivery_add) {
	this.delivery_add = delivery_add;
}
 public void setDelivery_email_id(String delivery_email_id) {
	this.delivery_email_id = delivery_email_id;
}
 public void setDelivery_phone_no(String delivery_phone_no) {
	this.delivery_phone_no = delivery_phone_no;
}
 public void setDeliveryId(String deliveryId) {
	this.deliveryId = deliveryId;
}
 public void setDeliveryName(String deliveryName) {
	this.deliveryName = deliveryName;
}
 public void setLocation(String location) {
	this.location = location;
}
 public void setStore_Id(String store_Id) {
	this.store_Id = store_Id;
}
 public RequestDispatcher directUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
	    RequestDispatcher r = request.getRequestDispatcher("/deliveryStaffhome.jsp") ;
	    return r;
	}
}
