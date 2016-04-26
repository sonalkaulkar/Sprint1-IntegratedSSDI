package model;

public class TechOrders {
public int orderid;
public int prodId;
public String prodname;
public String make;
public String company;
public String description;
public String custname;
public String custemail;
public String custphone;
public TechOrders(int orderid, int prodId, String prodname, String make, String company, String description,
		String custname, String custemail, String custphone) {
	this.orderid = orderid;
	this.prodId = prodId;
	this.prodname = prodname;
	this.make = make;
	this.company = company;
	this.description = description;
	this.custname = custname;
	this.custemail = custemail;
	this.custphone = custphone;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdname() {
	return prodname;
}
public void setProdname(String prodname) {
	this.prodname = prodname;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public String getCustemail() {
	return custemail;
}
public void setCustemail(String custemail) {
	this.custemail = custemail;
}
public String getCustphone() {
	return custphone;
}
public void setCustphone(String custphone) {
	this.custphone = custphone;
}


}
