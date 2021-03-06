package model.orderObserve.observable;

import java.sql.Date;
import java.sql.Timestamp;

public class orderDetails  implements IOrderData{
public int orderId;
public Timestamp date_of_order;
public String prodId;
public String make;
public String tech_Id;
public String store_Id;
public String customer_Id;
public String order_status;
public String delivery_id;
public String description;
public String payment_status;
public String location;

public orderDetails() {
	// TODO Auto-generated constructor stub
}
public orderDetails(int orderId,Timestamp date_of_order,String prodId,String make,String tech_Id,
		String store_Id,String customer_Id,String order_status,String delivery_id,String description,String payment_status,String location)
{
this.customer_Id=customer_Id;
this.orderId=orderId;
this.date_of_order=date_of_order;
this.prodId=prodId;
this.make=make;
this.tech_Id=tech_Id;
this.store_Id=store_Id;
this.order_status=order_status;
this.delivery_id=delivery_id;
this.description=description;
this.payment_status=payment_status;
this.location = location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getLocation() {
	return location;
}
public String getCustomer_Id() {
	return customer_Id;
}
public Timestamp getDate_of_order() {
	return date_of_order;
}
public String getDelivery_id() {
	return delivery_id;
}
public String getDescription() {
	return description;
}
public String getMake() {
	return make;
}
public String getOrder_status() {
	return order_status;
}
public int getOrderId() {
	return orderId;
}
public String getPayment_status() {
	return payment_status;
}
public String getProdId() {
	return prodId;
}
public String getStore_Id() {
	return store_Id;
}
public void setTech_Id(String tech_Id) {
	this.tech_Id = tech_Id;
}
public String getTech_Id() {
	return tech_Id;
}
public void setCustomer_Id(String customer_Id) {
	this.customer_Id = customer_Id;
}
public void setDate_of_order(Timestamp date_of_order) {
	this.date_of_order = date_of_order;
}
public void setDelivery_id(String delivery_id) {
	this.delivery_id = delivery_id;
}
public void setDescription(String description) {
	this.description = description;
}
public void setMake(String make) {
	this.make = make;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public void setOrderId(int order_id) {
	this.orderId = order_id;
}
public void setPayment_status(String payment_status) {
	this.payment_status = payment_status;
}
public void setProdId(String prodId) {
	this.prodId = prodId;
}
public void setStore_Id(String store_Id) {
	this.store_Id = store_Id;
}
}
