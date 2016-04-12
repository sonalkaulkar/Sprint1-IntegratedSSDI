/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
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
          //  System.out.println("username is"+l.username);
            //System.out.println("password is"+l.password);
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
        	PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            String query = "select password from login where username = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,l.getUsername());
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
            	
            	if(!rs.getString(1).equals(l.getPassword()) )
            	{
            	
            		return 5 ;
            	}
            }
            
             query = "update login set password = ?  where username = ?";
            
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1,new_password);
            stmt.setString(2,l.getUsername());
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
    
    
    public int addTechnician(technician T,Login L,String user) 
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
            query = "select storeid from store where manager_username = ? ";
            stmt = connection.prepareStatement(query);
            
  		  stmt.setString(1,user);
           rs =  stmt.executeQuery();
           String store_id = "";
            while (rs.next())
            { store_id = rs.getString(1);}
            query = "insert into technician values(?,?,?,?,?,?,?,?)";
           
           
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, T.getTechId());
            stmt.setString(2, T.getTechName());
            stmt.setString(3, T.getTechStatus());
            stmt.setInt(4, T.getNo_of_orders());
            stmt.setString(5, T.getTech_email_id());
            stmt.setString(6, T.getTech_phone_no());
            stmt.setString(7, store_id);
            stmt.setTimestamp(8, T.getLast_completed_timestamp());
            stmt.executeUpdate();
            query = "select max(techId) from technician";
            stmt = connection.prepareStatement(query);
            ResultSet rs4 = stmt.executeQuery();
            int tech_id = 0;
            if(rs4.next())
            {
            	tech_id = rs4.getInt(1);
            }
            query = "insert into login values(?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.setInt(3, tech_id);
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
    public int addDeliveryStaff(deliveryStaff D,Login l ,String user) 
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
            if (rs.next())
            { return 2;}
            query = "select storeid from store where manager_username = ? ";
            stmt = connection.prepareStatement(query);
            
  		  stmt.setString(1,user);
           rs =  stmt.executeQuery();
           String store_id = "";
            while (rs.next())
            { store_id = rs.getString(1);}
             query = "insert into deliverystaff values(?,?,?,?,?,?,?,?)";
            String username = "Del"+l.getUsername() ;
           
          
            stmt = connection.prepareStatement(query);
            stmt.setString(1, D.getDeliveryId());
            stmt.setString(2, D.getDeliveryName());
            stmt.setString(3, D.getLocation());
            stmt.setString(4, D.getDelivery_email_id());
            stmt.setString(5, D.getDelivery_phone_no());
            stmt.setString(6, store_id);
            stmt.setString(8,D.getDelivery_add());
            stmt.setInt(7,D.getNo_of_orders());
            stmt.executeUpdate();
            
            query = "select max(deliveryId) from deliverystaff";
            stmt = connection.prepareStatement(query);
            ResultSet rs4 = stmt.executeQuery();
            int del_id = 0;
            if(rs4.next())
            {
            	del_id = rs4.getInt(1);
            }
            query = "insert into login values(?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.setInt(3, del_id);
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
            String query = "select manager_username  from store where manager_email_id= ?";
            PreparedStatement stmt = null;
            Connection connection = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1,manager_emailid);
            System.out.println("print store_email id "+manager_emailid);
            ResultSet rs =  stmt.executeQuery();
            while (rs.next())
            {  String musername = rs.getString("manager_username");
            System.out.println("1"+s.getManager_Username());
            System.out.println("2"+musername);
            	if(!s.getManager_Username().equals(musername))
            	{return 2;}
            }	
        	int manager_update = 0;
            query = "select manager_username from store where storeid = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,s.getStoreId());
            rs =  stmt.executeQuery();
            while (rs.next())
            {  String man_username = rs.getString("manager_username");
            System.out.println("here"+man_username);
            	if (!man_username.equals(""))
            	{manager_update = 1;
              username = s.getManager_Username();}
            }
            System.out.println(";manager update"+ manager_update);
            
            
            
            
            query = "update  store set manager= ?,manager_phone_no = ?,manager_email_id = ? ,manager_username = ? where storeid=?";
            
           
            
            stmt = connection.prepareStatement(query);
            
            stmt.setString(1, managername);
            stmt.setString(2, manager_phone_no);
            stmt.setString(3, manager_emailid);
            stmt.setString(4, username);
            stmt.setString(5, s.getStoreId());
            System.out.println( "kljlkjlkjkl"+s.getStoreId());
            
            
            stmt.executeUpdate();
            
            if (manager_update != 1 )
            {
            query = "insert into login values(?,?,?)";
            stmt = connection.prepareStatement(query);
            
            stmt.setString(1,username);
            stmt.setString(2,username);
            stmt.setInt(3,0);
            stmt.executeUpdate();
            
            }
        
            
            
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
    
    
    public ArrayList<Store> searchStores(product p  ,String location ) 
    {   	  ArrayList<Store> slist = new ArrayList();
          
        try { ResultSet rs,rs1= null;
        	Connection connection = null;
        	PreparedStatement stmt = null;
        	String query = null;
        	connection = ConnectionUtil.getConnection(connectionData);
        	  System.out.println("vkjhckhkdfhb");
        	boolean isProduct = !p.getDescription().equals("");
        	System.out.println("isProduct"+isProduct);
        	boolean isCompany  = !p.getCompany().equals("");
        	System.out.println("isCompany"+isCompany);
        	boolean isLocation = !location.equals("");
        	System.out.println("isLocation"+isLocation);
        	if (isProduct && !isCompany && !isLocation)
        	{  System.out.println("first");
        		query = "select storeId from storeproduct where prodId in (select prodId from product where description = ? ) ;";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, p.getDescription());
        	}
        	if (!isProduct && isCompany && !isLocation)
        	{    System.out.println("second");
        		query = "select storeId from storeproduct where prodId in (select prodId from product where company  = ? ); ";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, p.getDescription());
        	}
        	if (!isProduct && !isCompany && isLocation)
        	{	 System.out.println("third");
        		query = "select storeId from store where storeLocation  = ?  ;";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, location);
        	}
        	if (isProduct && isCompany && !isLocation)
        	{	 System.out.println("forth");
        		query = "select storeId from storeproduct where prodId in (select prodId from product where company  = ? and description = ? ) ;";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, p.getCompany());
        		stmt.setString(2, p.getDescription());
        	}
        	if (isProduct && !isCompany && isLocation)
        	{	 System.out.println("fifth");
        		query = "select SP.storeId from store S ,storeproduct SP where  S.storeId = SP.storeId and storeLocation = ? and prodId in (select prodId from product where description = ? ); ";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, location);
        		stmt.setString(2, p.getDescription());
        	}
        	
        	if (!isProduct && isCompany && isLocation)
        	{	 System.out.println("sixth");
        		query = "select SP.storeId from storeproduct SP,store S where   S.storeId = SP.storeId and S.storeLocation = ? and prodId in (select prodId from product where company  = ?  ) ;";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, location);
        		stmt.setString(2, p.getCompany());
        	}
        	if (isProduct && isCompany && isLocation)
        	{	 System.out.println("seventh");
        		query = "select SP.storeId from storeproduct SP , store S  where    S.storeId = SP.storeId and  storeLocation = ? and prodId in (select prodId from product where company  = ? and description = ? ) ;";
        		stmt = connection.prepareStatement(query);
        		stmt.setString(1, location);
        		stmt.setString(2, p.getCompany());
        		stmt.setString(3, p.getDescription());
        	}
        	
            
            rs = stmt.executeQuery();
            while (rs.next())
            {   query = "select storeId,storeName,storeAdd,storeLocation,store_phone_no,store_email_id from store where storeId = ?;";
            	stmt = connection.prepareStatement(query);
            	stmt.setString(1, rs.getString(1));
            	rs1 = stmt.executeQuery();
            	if(rs1.next())
            	{
            	String  StoreId = rs1.getString(1);
            	String StoreName = rs1.getString(2);
            	String StoreAdd = rs1.getString(3);
            	String StoreLocation = rs1.getString(4);
            	String Store_Phone_No = rs1.getString(5);
            	String Store_Email_Id = rs1.getString(6);
            	Store s = new Store(StoreId,StoreName,StoreAdd,StoreLocation,Store_Phone_No,Store_Email_Id,"","","","");
            	slist.add(s);
            	}
            }   
            return slist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return slist;
        }
       
    }
    public int newRequest(Store s,product p ,String location ,String description ,String username) 
    { 
       
        try { 
        	  ArrayList<Integer> delids = new ArrayList();
        	  
        	  String query = "select roleid from login where username = ?";
              int cust_id = 0;
              PreparedStatement stmt = null;
              Connection connection = null;
              connection = ConnectionUtil.getConnection(connectionData);
              stmt = connection.prepareStatement(query);
              stmt.setString(1,username);
              ResultSet rs = stmt.executeQuery();
              if (rs.next())
              {
              	cust_id = rs.getInt(1);
              }
        	
      
             System.out.println(location);
             System.out.println(s.getStoreId());
             query = "select min(no_of_orders) from deliverystaff where location = ? and store_id = ?;";
             stmt = connection.prepareStatement(query);
            stmt.setString(1, location);
            stmt.setString(2, s.getStoreId());
             ResultSet rs1 = stmt.executeQuery();
             int minimum_order = 0 ;
             if(rs1.next())
             {
             minimum_order = rs1.getInt(1);
             System.out.println("Minimum order"+minimum_order);
             }
             query = "select deliveryId from deliverystaff  where no_of_orders = ? and location = ? and store_id = ?;";
             stmt = connection.prepareStatement(query);
             stmt.setInt(1, minimum_order);
             stmt.setString(2, location);
             stmt.setString(3, s.getStoreId());
             ResultSet rs2 = stmt.executeQuery();
             while (rs2.next())
             {   System.out.println("delivery ids "+rs2.getInt(1));
            	 delids.add(rs2.getInt(1));
             }
             query = "select prodId from product where description = ? and company = ?  ;";
             stmt = connection.prepareStatement(query);
             stmt.setString(1, p.getDescription());
             stmt.setString(2, p.getCompany()); 
             
             ResultSet rs3 = stmt.executeQuery();
             int prodId = 0;
             if (rs3.next())
             {
             prodId = rs3.getInt(1);}
             
             int size = delids.size();
             System.out.println("SIze is "+size);
             Random ran = new Random();
             int x = ran.nextInt(size) ;
             System.out.println("random no "+x);
             int deliveryId = delids.get(x);
             java.util.Date utilDate = new java.util.Date();
             Calendar cal = Calendar.getInstance();
             cal.setTime(utilDate);
             cal.set(Calendar.MILLISECOND, 0);
             java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime()); 
            query = "insert into orderdetails(date_of_order,prodId,make,tech_id,store_id,customer_id,order_status,delivery_id,description,payment_status) values(?,?,?,?,?,?,?,?,?,?)";            
            
            stmt = connection.prepareStatement(query);
            
            stmt.setTimestamp(1, t);
            stmt.setInt(2,prodId );
            stmt.setString(3, p.getCompany());
            stmt.setInt(4, 1);
            stmt.setString(5, s.getStoreId());
            stmt.setInt(6, cust_id);
            stmt.setString(7, "Placed");
            stmt.setInt(8, deliveryId);
            stmt.setString(9, description);
            stmt.setString(10, "");
            stmt.executeUpdate();
            query = "select max(orderId) from orderdetails";
            stmt = connection.prepareStatement(query);
            ResultSet rs4 = stmt.executeQuery();
            int order_id = 0;
            while(rs4.next())
            {   
            	order_id = rs4.getInt(1);
            	 System.out.print("order id iiserted"+order_id);
            	 query = "update deliverystaff set no_of_orders = ? where deliveryId = ?";
            	 stmt = connection.prepareStatement(query);
                 stmt.setInt(1, minimum_order + 1);
                 stmt.setInt(2, deliveryId);
                 stmt.executeUpdate();
            }
               return order_id;	
                  
         }catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 

   
    public ArrayList<OrderHistory> viewHistory(String  username) 
    {   	  ArrayList<OrderHistory> olist = new ArrayList();
       
        try { 
        	Connection connection = null;
            String query = "select roleid from login where username = ?";
            int cust_id = 0;
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
            	cust_id = rs.getInt(1);
            }
            System.out.println("username"+username);
            System.out.println("customer id is"+cust_id);
            query = "select orderId,date_of_order,prodId,description,store_id,order_status from orderdetails where customer_id = ?; ";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,cust_id);
            rs = stmt.executeQuery();
            while (rs.next())
            {
            	int  orderId = rs.getInt(1);
            	Timestamp t = rs.getTimestamp(2);
            	int  prodId  = rs.getInt(3);
            	String status = rs.getString(6);
            	int store_id = rs.getInt(5);
            	String desc = rs.getString(4);
            	query = "select description,company from product where prodId = ? ";
            	stmt = connection.prepareStatement(query);
                stmt.setInt(1,prodId);
                ResultSet rs1 = stmt.executeQuery();
                String company = null ,product= null,StoreName = null;
                if (rs1.next())
                {
                 company = rs1.getString(2);
                 product = rs1.getString(1);
                }
                query = "select storeName from store where storeId  = ? ";
            	stmt = connection.prepareStatement(query);
                stmt.setInt(1,store_id);
                 rs1 = stmt.executeQuery();
                 if(rs1.next())
                 {
                   StoreName = rs1.getString(1);
                   System.out.println("store name is"+StoreName);
                 }
            	OrderHistory o = new OrderHistory(orderId, product, company, desc, StoreName, status);
            			olist.add(o);
            
            }
            return olist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return olist;
        }
       
    }
    
    
    public ArrayList<PickUpOrder> viewPickUp(String username) 
    {   	  ArrayList<PickUpOrder> plist = new ArrayList();
       
        try { 
        	Connection connection = null;
        	 String query = "select roleid from login where username = ?";
             int delivery_id = 0;
             PreparedStatement stmt = null;
             connection = ConnectionUtil.getConnection(connectionData);
             stmt = connection.prepareStatement(query);
             stmt.setString(1,username);
             ResultSet rs = stmt.executeQuery();
             if (rs.next())
             {
             	delivery_id = rs.getInt(1);
             }
             
           query = "select orderId,customer_id,prodId    from orderdetails where delivery_id = ? and order_status = 'Placed';";
            
          
            connection = ConnectionUtil.getConnection(connectionData);
            
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,delivery_id);
            rs = stmt.executeQuery();
            while (rs.next())
            {   
            	int  orderId = rs.getInt(1);
            	int  custid  = rs.getInt(2);
            	int prodid = rs.getInt(3);
            	System.out.println("hiii"+orderId+"cust"+custid+"prod"+prodid);
            	query = "select description from product where prodId = ? ";
            	stmt = connection.prepareStatement(query);
                stmt.setInt(1,prodid);
                ResultSet rs1 = stmt.executeQuery();
                String product = null;
                if (rs1.next())
                {
                 product = rs1.getString(1);
                }
                query = "select customerName,customer_email_id,customer_phone_no ,customer_add from customer where customerId  = ? ";
            	stmt = connection.prepareStatement(query);
                stmt.setInt(1,custid);
                 rs1 = stmt.executeQuery();
                 if(rs1.next())
                 {
            
            	String CustomerName = rs1.getString(1);
            	String Customeremail = rs1.getString(2);
            	String Customerphone = rs1.getString(3);
            	String Customeradd = rs1.getString(4);
            	PickUpOrder p = new PickUpOrder(orderId, CustomerName, Customeradd, Customerphone, Customeremail, product);
            	System.out.println(CustomerName+"add"+Customeradd+"phone"+Customerphone+"email"+Customeremail+"prod"+product);
            			plist.add(p);
                 }
            }
            return plist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return plist;
        }
       
    }
    
    public int addProduct(product p,int store_id) 
    { 
       
        try { 
        	Connection connection = null;
        	int prod_id ;
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            System.out.println(p.getDescription());
            System.out.println(p.getCompany());
            String query = "select prodId from product where description = ? and company = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,p.getDescription());
            stmt.setString(2,p.getCompany());
            ResultSet  rs1 = stmt.executeQuery();
            if(rs1.next())
            {
              prod_id  = rs1.getInt(1);
            }
            else
            {
            	return 1 ;
            }
            query = "select prodId from storeproduct where prodId = ? and storeId = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,prod_id);
            stmt.setInt(2,store_id);
            rs1 = stmt.executeQuery();
            if (!rs1.next())
            {
            
            query = "insert into storeproduct  values(?,?)";
          
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, store_id);
            stmt.setInt(2, prod_id);
            stmt.executeUpdate();
               return 0;
            }
            else
            {System.out.println("gggg"+rs1.getInt(1));
            return 2;}
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 3;
        }
       
    } 

    public int registration(Customer C,Login L) 
    { 
       
        try { 
        	String username = "Cus"+L.getUsername();
        	String password = L.getPassword();
        	Connection connection = null;
        	while(true){connection = ConnectionUtil.getConnection(connectionData);
        		
        		 PreparedStatement stmt = null;
               String  query = "select * from customer  where  customer_email_id = ?";
                 stmt = connection.prepareStatement(query);
              
        		  stmt.setString(1,C.getCustomer_email_id());
                  ResultSet rs =  stmt.executeQuery();
                  while (rs.next())
                  { return 2;}
                  
            query = "insert into customer values(?,?,?,?,?,?)";
           
           
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, C.getCustomerId());
            stmt.setString(2, C.getCustomerName());
            stmt.setString(3,C.getLocation() );
            stmt.setString(4, C.getCustomer_email_id());
            stmt.setString(5, C.getCustomer_phone_no());
            stmt.setString(6, C.getCustomer_address());
          
            stmt.executeUpdate();
            query = "insert into login values(?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, C.getCustomerId());
            stmt.executeUpdate();
            

          
            return 0;
        	}
                  
        } catch (SQLException ex) {
            
            System.out.println("Exception in registration method");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 
    
    public Customer loadprofiledetails(String username) 
    {   	 // Store s = new Store();
    	Customer cout = null;
        try {  
        	Connection connection = null;
        	  PreparedStatement stmt = null;
        	  String customerId = null;
              connection = ConnectionUtil.getConnection(connectionData);
              String query = "select roleId from login where username = ? " ;
                
              stmt = connection.prepareStatement(query);
              
    		  stmt.setString(1,username);
              ResultSet rs =  stmt.executeQuery();
              while (rs.next())
              { customerId = rs.getString(1); }
             query = "select customerId,customerName,location,customer_email_id,customer_phone_no,customer_add from customer where customerId = ?;";
            
          
            stmt = connection.prepareStatement(query);
            stmt.setString(1,customerId );
            rs = stmt.executeQuery();
            while (rs.next())
            {   System.out.println("sonal");
            	String  CustomerId = rs.getString(1);
            	String CustomerName = rs.getString(2);
            	String location= rs.getString(3);
            	String Customer_email_id = rs.getString(4);
            	String Customer_Phone_No = rs.getString(5);
            	String  Customer_add= rs.getString(6);
            	System.out.println("vjkfd services dao"+Customer_add);
               cout = new Customer(CustomerId,CustomerName,location,Customer_email_id,Customer_Phone_No,Customer_add);
        
            }
            return cout;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return cout;
        }
       
    }
    
    public int updateCustomer(Customer c) 
    { 
       System.out.println("i m here ");
        try { 
        	Connection connection = null;
        	
        	//System.out.println("Phone no"+s.getStore_Phone_No());
        //	System.out.println("email id" +s.getStore_Email_Id());
        	 System.out.println("services"+c.getCustomer_address());
            String query = "update customer set  customerName = ? , location = ? , customer_email_id = ? ,customer_phone_no = ? , customer_add = ? where customerId = ?";
            
            PreparedStatement stmt = null;
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setString(1, c.getCustomerName());
            stmt.setString(2, c.getLocation());
            stmt.setString(3, c.getCustomer_email_id());
            stmt.setString(4, c.getCustomer_phone_no());
            stmt.setString(5, c.getCustomer_address());
            stmt.setString(6, c.getCustomerId());
            stmt.executeUpdate();
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    public ArrayList<technician> viewtechnician(String user) 
    {   	  ArrayList<technician> tlist = new ArrayList();
       
        try { 
        	Connection connection = null;
        	 connection = ConnectionUtil.getConnection(connectionData);
        	 String query = "select storeid from store where manager_username = ?";
             int store_id = 0;
             PreparedStatement stmt = null;
             
             stmt = connection.prepareStatement(query);
             stmt.setString(1,user);
             ResultSet rs = stmt.executeQuery();
             if (rs.next())
             {
             	store_id = rs.getInt(1);
             }
            query = "select techId,techName,tech_email_id,tech_phone_no from technician where techId <> '1' and store_id = ?;";
            
           
           
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, store_id);
            rs = stmt.executeQuery();
            java.util.Date utilDate = new java.util.Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(utilDate);
            cal.set(Calendar.MILLISECOND, 0);
            java.sql.Timestamp t1 = new java.sql.Timestamp(utilDate.getTime());
            while (rs.next())
            {
            	String  TechId = rs.getString(1);
            	String TechName = rs.getString(2);
            	String Tech_Phone_No = rs.getString(4);
            	String Tech_Email_Id = rs.getString(3);
            	technician t = new technician(TechId,TechName,"",0,Tech_Phone_No,Tech_Email_Id,"",t1);
            	tlist.add(t);
            
            }
            return tlist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return tlist;
        }
       
    }
    
    
    public int deleteTechnician(technician t) 
    { 
       
        try { 
        	
        	Connection connection = null;

            PreparedStatement stmt = null;
        	connection = ConnectionUtil.getConnection(connectionData);
        	String query = "select count(*)  from orderdetails where  tech_id = ?";
        	stmt = connection.prepareStatement(query);
            stmt.setString(1, t.getTechId());
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
            	return 2 ;
            }
        	 query = "delete from technician  where techId = ?";
            
            
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, t.getTechId());
            stmt.executeUpdate();
            
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    
    public int deletedelivery(deliveryStaff d) 
    { 
       
        try { 
        	Connection connection = null;

            PreparedStatement stmt = null;
        	connection = ConnectionUtil.getConnection(connectionData);
        	String query = "select count(*)  from orderdetails where  delivery_id = ?";
        	stmt = connection.prepareStatement(query);
            stmt.setString(1, d.getDeliveryId());
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
            	return 2 ;
            }
            
            query = "delete from deliverystaff  where deliveryId = ?";
            
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, d.getDeliveryId());
            stmt.executeUpdate();
            
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    }
    
    
    public ArrayList<deliveryStaff> viewdelivery(String user) 
    {   	  ArrayList<deliveryStaff> dlist = new ArrayList();
       
        try { 
        	Connection connection = null;
        	
        	 String query = "select storeid from store where manager_username = ?";
             int store_id = 0;
             PreparedStatement stmt = null;
             connection = ConnectionUtil.getConnection(connectionData);
             stmt = connection.prepareStatement(query);
             stmt.setString(1,user);
             ResultSet rs = stmt.executeQuery();
             if (rs.next())
             {
             	store_id = rs.getInt(1);
             }
            query = "select deliveryId,deliveryName,delivery_email_id,delivery_phone_no from deliverystaff where store_id = ?;";
            
            
            connection = ConnectionUtil.getConnection(connectionData);
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, store_id);
            rs = stmt.executeQuery();
            while (rs.next())
            {
            	String  DelId = rs.getString(1);
            	String DelName = rs.getString(2);
            	String Del_Phone_No = rs.getString(4);
            	String Del_Email_Id = rs.getString(3);
            	deliveryStaff d = new deliveryStaff(DelId,DelName,"",Del_Email_Id,Del_Phone_No,"","",0);
            	dlist.add(d);
            
            }
            return dlist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return dlist;
        }
       
    }
    
    public ArrayList<orderDetails> viewStoreOrder(String username) 
    {   	  ArrayList<orderDetails> plist = new ArrayList();
       
        try { 
        	Connection connection = null;
        	 String query = "select storeid from store where manager_username = ?";
             int store_id = 0;
             PreparedStatement stmt = null;
             connection = ConnectionUtil.getConnection(connectionData);
             stmt = connection.prepareStatement(query);
             stmt.setString(1,username);
             ResultSet rs = stmt.executeQuery();
             if (rs.next())
             {
             	store_id = rs.getInt(1);
             }
             
           query = "select *  from orderdetails where store_id = ? ;";
            
          
            connection = ConnectionUtil.getConnection(connectionData);
            
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,store_id);
            rs = stmt.executeQuery();
            while (rs.next())
            {   
            	

            	String order_id = rs.getString(1);
            	Timestamp date = rs.getTimestamp(2);
            	String make = rs.getString(4);
            	String orderstatus = rs.getString(8);
            	String payment = rs.getString(11);
            	String desc = rs.getString(10);
            	String del_id = Integer.toString(rs.getInt(9));
            	orderDetails o= new orderDetails(order_id, date,"0", make,"0","0","0",orderstatus,del_id,desc,payment);
            	//System.out.println(CustomerName+"add"+Customeradd+"phone"+Customerphone+"email"+Customeremail+"prod"+product);
            			plist.add(o);
                 
            }
            return plist;
                  
        } catch (SQLException ex) {
            
            System.out.println("hiii");
                 
            Logger.getLogger(ServicesDao.class.getName()).log(Level.SEVERE, null, ex);
            return plist;
        }
       
    }
    
}
