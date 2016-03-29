package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class Store implements  User{

	public String StoreId;
	public String StoreName;
	public String StoreAdd;
	public String StoreLocation;
	public String Store_Phone_No;
	public String Store_Email_Id;
	public String Manager;
	public String Manager_Phone_No;
	public String Manager_Email_Id;
	public String Manager_Username;
	
	public void setManager_Username(String manager_Username) {
		Manager_Username = manager_Username;
	}
	public String getManager_Username() {
		return Manager_Username;
	}
	
	public Store() {
		// TODO Auto-generated constructor stub
	}
	
	public Store(String store_id)
	{
		
		StoreId = store_id;
	}
	
	public Store(String storeid, String storename, String storeadd, 
			String storelocation, String storephone, String storeemail, 
			String manager, String managerphone, String manageremail,String managerusername){
	
		StoreId = storeid;
		StoreName = storename;
		StoreAdd = storeadd;
		StoreLocation = storelocation;
		Store_Phone_No = storephone;
		Store_Email_Id = storeemail;
		Manager = manager;
		Manager_Phone_No = managerphone;
		Manager_Email_Id = manageremail;
		Manager_Username = managerusername;
	}
	
	
	public Store(String storeid, String storename, String storeadd, 
			String storelocation, String storephone, String storeemail){
	
		StoreId = storeid;
		StoreName = storename;
		StoreAdd = storeadd;
		StoreLocation = storelocation;
		Store_Phone_No = storephone;
		Store_Email_Id = storeemail;
		
	}

	
	public String getManager() {
		return Manager;
	}
	
	public String getManager_Email_Id() {
		return Manager_Email_Id;
	}
	
	public String getManager_Phone_No() {
		return Manager_Phone_No;
	}
	
	public String getStore_Email_Id() {
		return Store_Email_Id;
	}
	
	public String getStore_Phone_No() {
		return Store_Phone_No;
	}
	
	public String getStoreAdd() {
		return StoreAdd;
	}
	
	public String getStoreId() {
		return StoreId;
	}
	
	public String getStoreLocation() {
		return StoreLocation;
	}
	
	public String getStoreName() {
		return StoreName;
	}
	
	public void setManager(String manager) {
		Manager = manager;
	}
	
	public void setManager_Email_Id(String manager_Email_Id) {
		Manager_Email_Id = manager_Email_Id;
	}
	
	public void setManager_Phone_No(String manager_Phone_No) {
		Manager_Phone_No = manager_Phone_No;
	}
	
	public void setStore_Email_Id(String store_Email_Id) {
		Store_Email_Id = store_Email_Id;
	}
	
	public void setStore_Phone_No(String store_Phone_No) {
		Store_Phone_No = store_Phone_No;
	}
	
	public void setStoreAdd(String storeAdd) {
		StoreAdd = storeAdd;
	}
	
	public void setStoreId(String storeId) {
		StoreId = storeId;
	}
	
	public void setStoreLocation(String storeLocation) {
		StoreLocation = storeLocation;
	}
	
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public RequestDispatcher directUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
	    RequestDispatcher r = request.getRequestDispatcher("/StrManagerHome.jsp") ;
	    return r;
	}
}
