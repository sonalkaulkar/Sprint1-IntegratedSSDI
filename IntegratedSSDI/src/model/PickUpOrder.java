package model;

public class PickUpOrder {

	public int orderId;
	public String cust_name;
	public String cust_address;
	public String cust_phone_no;
	public String cust_emailid;
	public String product;

	
	public PickUpOrder() {
		// TODO Auto-generated constructor stub
	}
	public PickUpOrder(int orderId , String cust_name,String cust_address,String cust_phone_no ,String cust_emailid ,String product)
	{
		this.orderId = orderId;
		this.product = product;
		this.cust_address = cust_address;
		this.cust_phone_no  = cust_phone_no ;
		this.cust_emailid = cust_emailid;
		this.cust_name = cust_name;
	}
	
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}public String getCust_name() {
		return cust_name;
	}
	
	
	public String getProduct() {
		return product;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setCust_phone_no(String cust_phone_no) {
		this.cust_phone_no = cust_phone_no;
	}
	public void setCust_emailid(String cust_emailid) {
		this.cust_emailid = cust_emailid;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_phone_no() {
		return cust_phone_no;
	}
	public String getCust_emailid() {
		return cust_emailid;
	}
	public String getCust_address() {
		return cust_address;
	}
	
}
