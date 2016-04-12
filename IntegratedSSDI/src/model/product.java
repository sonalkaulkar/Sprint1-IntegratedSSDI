package model;

public class product {
public String prodId;
public String description;
public String company;

  public String getCompany() {
	return company;
}
  
  public void setCompany(String company) {
	this.company = company;
}
public product() {
	// TODO Auto-generated constructor stub
}
public product(String prodId,String description,String company)
{
	this.description=description;
	this.prodId=prodId;
	this.company =  company;
}
public String getDescription() {
	return description;
}
public String getProdId() {
	return prodId;
}
public void setDescription(String description) {
	this.description = description;
}
public void setProdId(String prodId) {
	this.prodId = prodId;
}
}
