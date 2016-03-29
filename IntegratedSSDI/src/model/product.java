package model;

public class product {
public String prodId;
public String description;
public product() {
	// TODO Auto-generated constructor stub
}
public product(String prodId,String description)
{
	this.description=description;
	this.prodId=prodId; 
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
