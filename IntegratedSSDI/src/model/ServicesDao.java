/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.uncc.util.ConnectionUtil;
import org.uncc.util.IConnectionData;

import model.*;
/**
 *
 * @author skaul
 */
public class ServicesDao {
	IConnectionData connectionData;
	ServicesDao(IConnectionData connectionData) {
		this.connectionData = connectionData;
	}
  
    public int checkLogin(Login l) 
    { 
       
        try { 
        	Connection connection = null;
            String query = "SELECT * FROM login where username = ? and password = ?";
            System.out.println("username is"+l.username);
            System.out.println("password is"+l.password);
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, l.username);
            stmt.setString(2, l.password);
            ResultSet rs =  stmt.executeQuery();
            
            while (rs.next())
            {System.out.println("inside check login");
               return 0;	
            }
 return 1;         
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 
    

    public int addStore(Store s) 
    { 
       
        try { 
        	Connection connection = null;
            String query = "insert into store values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, s.getStoreId());
            stmt.setString(2, s.getStoreName());
            stmt.setString(3, s.getStoreAdd());
            stmt.setString(4, s.getStoreLocation());
            stmt.setString(5, s.getStore_Phone_No());
            stmt.setString(6, s.getStore_Email_Id());
            stmt.setString(7, "");
            stmt.setString(8, "");
            stmt.setString(9, "");
            stmt.setString(10, "");
            stmt.executeUpdate();
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 

    
    public int updateStore(Store s) 
    { 
       System.out.println("i m here ");
        try { 
        	Connection connection = null;
        	
        	System.out.println("Phone no"+s.getStore_Phone_No());
        	System.out.println("email id" +s.getStore_Email_Id());
        	
            String query = "update store set  storeName = ? , storeAdd = ? , storeLocation = ? ,store_phone_no = ? , store_email_id = ? where storeId = ?";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, s.getStoreName());
            stmt.setString(2, s.getStoreAdd());
            stmt.setString(3, s.getStoreLocation());
            stmt.setString(4, s.getStore_Phone_No());
            stmt.setString(5, s.getStore_Email_Id());
            stmt.setString(6, s.getStoreId());
            stmt.executeUpdate();
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    public int deleteStore(Store s) 
    { 
       
        try { 
        	Connection connection = null;
            String query = "delete from store  where storeId = ?";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, s.getStoreId());
            stmt.executeUpdate();
            
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    
    public int updatePassword(Login l,String new_password) 
    { 
       
        try { 
        	Connection connection = null;
            String query = "update login set password = ?  where password = ?";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1,new_password);
            stmt.setString(2,l.getPassword());
            stmt.executeUpdate();
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
        
    }
    
    
    public ArrayList<Store> viewStores() 
    {   	  ArrayList<Store> slist = new ArrayList();
       
        try { 
        	Connection connection = null;
            String query = "select storeId,storeName,storeAdd,storeLocation,store_phone_no,store_email_id,manager from store LIMIT 10;";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
            	String  StoreId = rs.getString(1);
            	String StoreName = rs.getString(2);
            	String StoreAdd = rs.getString(3);
            	String StoreLocation = rs.getString(4);
            	String Store_Phone_No = rs.getString(5);
            	String Store_Email_Id = rs.getString(6);
            	String Manager = rs.getString(7);
            	Store s = new Store(StoreId,StoreName,StoreAdd,StoreLocation,Store_Phone_No,Store_Email_Id,Manager,"","","");
            	slist.add(s);
            
            }
            return slist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return slist;
        }
       
    }
    
    
    public int addTechnician(technician T,Login L) 
    { 
       
        try { 
        	String username = "Tec"+L.getUsername();
        	Connection connection = null;
        	while(true){connection = ConnectionUtil.getConnection(connectionData);
        		
        		 PreparedStatement stmt = null;
               String  query = "select * from technician  where  tech_email_id = ?";
                 stmt = connection.prepareStatement(query);
              
        		  stmt.setString(1,T.getTech_email_id());
                  ResultSet rs =  stmt.executeQuery();
                  while (rs.next())
                  { return 2;}
                  
            query = "insert into technician values(?,?,?,?,?,?,?,?)";
            
           
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, T.getTechId());
            stmt.setString(2, T.getTechName());
            stmt.setString(3, T.getTechStatus());
            stmt.setInt(4, T.getNo_of_orders());
            stmt.setString(5, T.getTech_email_id());
            stmt.setString(6, T.getTech_phone_no());
            stmt.setString(7, T.getStore_id());
            stmt.setTimestamp(8, T.getLast_completed_timestamp());
            stmt.executeUpdate();
            query = "insert into login values(?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.executeUpdate();
            

          
            return 0;
        	}
                  
        } catch (SQLException ex) {
            
            System.out.println("Exception in addtechnician method");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 
    /**
    *
    * @author sadla
    */
    public int addDeliveryStaff(deliveryStaff D,Login l ) 
    { 
       
        try { 
        	Connection connection = null;
        	 PreparedStatement stmt = null;
        	  connection = ConnectionUtil.getConnection(connectionData);
        	String query = "select * from deliverystaff  where  delivery_email_id = ?";
            stmt = connection.prepareStatement(query);
            System.out.println(D.getDelivery_email_id());
            stmt.setString(1,D.getDelivery_email_id());
            ResultSet rs =  stmt.executeQuery();
            while (rs.next())
            { return 2;}
        	
             query = "insert into deliverystaff values(?,?,?,?,?,?,?)";
            String username = "Del"+l.getUsername() ;
           
          
            stmt = connection.prepareStatement(query);
            stmt.setString(1, D.getDeliveryId());
            stmt.setString(2, D.getDeliveryName());
            stmt.setString(3, D.getLocation());
            stmt.setString(4, D.getDelivery_email_id());
            stmt.setString(5, D.getDelivery_phone_no());
            stmt.setString(6, D.getStore_Id());
            stmt.setNString(7,D.getDelivery_add());
            stmt.executeUpdate();
            

            query = "insert into login values(?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.executeUpdate();
            
            
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("Exception in addDeliveryStaff method");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    /**
    *
    * @author sadla
    */
    public int AddStoreManager(Store s ) 
    { 
       
        try { 
        	String managername = s.getManager();
        	String manager_phone_no = s.getManager_Phone_No();
        	String manager_emailid = s.getManager_Email_Id();
        	String username = "Str"+s.getManager_Username();
        	
        	Connection connection = null;
            String query = "update  store set manager= ?,manager_phone_no = ?,manager_email_id = ? ,manager_username = ? where storeid=?";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            
            stmt.setString(1, managername);
            stmt.setString(2, manager_phone_no);
            stmt.setString(3, manager_emailid);
            stmt.setString(4, username);
            stmt.setString(5, s.getStoreId());
            System.out.println( "kljlkjlkjkl"+s.getStoreId());
            
            
            stmt.executeUpdate();
            
            
            query = "insert into login values(?,?)";
            stmt = connection.prepareStatement(query);
            
            stmt.setString(1,username);
            stmt.setString(2,username);
            stmt.executeUpdate();
            
            
            query = "select * from store where manager_email_id= ?";
            stmt = connection.prepareStatement(query);
            
            stmt.setString(1,manager_emailid);
            ResultSet rs =  stmt.executeQuery();
            while (rs.next())
            { return 2;}
            
            
            return 0;	
            
                                
        } catch (SQLException ex) {
            
            System.out.println("Exception in addstoremanger method");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    
    public Store loadstoredetails(Store s) 
    {   	 // Store s = new Store();
    	Store sout = null;
        try {  
        	Connection connection = null;
            String query = "select storeId,storeName,storeAdd,storeLocation,store_phone_no,store_email_id from store where storeId = ?;";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, s.getStoreId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
            	String  StoreId = rs.getString(1);
            	String StoreName = rs.getString(2);
            	String StoreAdd = rs.getString(3);
            	String StoreLocation = rs.getString(4);
            	String Store_Phone_No = rs.getString(5);
            	String Store_Email_Id = rs.getString(6);
           
               sout = new Store(StoreId,StoreName,StoreAdd,StoreLocation,Store_Phone_No,Store_Email_Id,"","","","");
        
            }
            return sout;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return sout;
        }
       
    }
    
    public Store loadstoremanagerdetails(Store s) 
    {   	 // Store s = new Store();
    	Store sout = null;
        try {  
        	Connection connection = null;
            String query = "select manager_username, manager,manager_email_id,manager_phone_no from store where storeId = ?;";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, s.getStoreId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
            	String  manager_username = rs.getString(1);
            	String manager = rs.getString(2);
            	String manager_Phone_No = rs.getString(4);
            	String manager_Email_Id = rs.getString(3);
                
               sout = new Store(s.getStoreId(),"","","","","",manager,manager_Phone_No,manager_Email_Id,manager_username);
        
            }
            return sout;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return sout;
        }
       
    }
}
