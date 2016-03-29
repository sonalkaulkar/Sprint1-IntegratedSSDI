package model;



import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;



public class technician implements  User{
public String techId;
public String techName;
public String techStatus;
public int no_of_orders;
public String tech_email_id;
public String tech_phone_no;
public String store_id;
public Timestamp last_completed_timestamp;
public technician() {
	// TODO Auto-generated constructor stub
}
public technician(String techId,String techName,String techStatus,int no_of_orders,String tech_email_id,
		String tech_phone_no,String store_id,Timestamp last_completed_timestamp)
{
this.techId=techId;
this.techName=techName;
this.techStatus=techStatus;
this.no_of_orders=no_of_orders;
this.tech_email_id=tech_email_id;
this.tech_phone_no=tech_phone_no;
this.store_id=store_id;
this.last_completed_timestamp=last_completed_timestamp;
}
public Timestamp getLast_completed_timestamp() {
	return last_completed_timestamp;
}
public int getNo_of_orders() {
	return no_of_orders;
}
public String getStore_id() {
	return store_id;
}
public String getTech_email_id() {
	return tech_email_id;
}
public String getTech_phone_no() {
	return tech_phone_no;
}
public String getTechId() {
	return techId;
}
public String getTechName() {
	return techName;
}
public String getTechStatus() {
	return techStatus;
}
public void setLast_completed_timestamp(Timestamp last_completed_timestamp) {
	this.last_completed_timestamp = last_completed_timestamp;
}
public void setNo_of_orders(int no_of_orders) {
	this.no_of_orders = no_of_orders;
}
public void setStore_id(String store_id) {
	this.store_id = store_id;
}
public void setTech_email_id(String tech_email_id) {
	this.tech_email_id = tech_email_id;
}
public void setTech_phone_no(String tech_phone_no) {
	this.tech_phone_no = tech_phone_no;
}
public void setTechId(String techId) {
	this.techId = techId;
}
public void setTechName(String techName) {
	this.techName = techName;
}
public void setTechStatus(String techStatus) {
	this.techStatus = techStatus;
}
@Override
public RequestDispatcher directUser(HttpServletRequest request) {
	// TODO Auto-generated method stub
    RequestDispatcher r = request.getRequestDispatcher("/technicianhome.jsp") ;
    return r;
}
}
