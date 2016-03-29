package model;

public class storeProduct {
public String storeId;
public String prodId;
public storeProduct() {
	// TODO Auto-generated constructor stub
}
public storeProduct(String prodId,String storeId)
{
	this.prodId=prodId;
	this.storeId=storeId;
}
public String getProdId() {
	return prodId;
}
public String getStoreId() {
	return storeId;
}
public void setProdId(String prodId) {
	this.prodId = prodId;
}
public void setStoreId(String storeId) {
	this.storeId = storeId;
}
}
