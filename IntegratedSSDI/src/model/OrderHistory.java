package model;

public class OrderHistory {

	public int orderId;
	public String product;
	public String company;
	public String desc;
	public String storeName;
	public String status;
	
	public OrderHistory() {
		// TODO Auto-generated constructor stub
	}
	public OrderHistory(int orderId ,String product,String company ,String desc ,String storeName,String status )
	{
		this.orderId = orderId;
		this.product = product;
		this.company = company;
		this.desc = desc;
		this.storeName = storeName;
		this.status = status;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getStatus() {
		return status;
	}
	public String getProduct() {
		return product;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getDesc() {
		return desc;
	}
	public String getCompany() {
		return company;
	}
	
	
}
