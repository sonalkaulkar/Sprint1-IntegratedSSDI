/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skaul
 */
public class Services {
  Connection conn; 
    public Services() throws ClassNotFoundException 
    { 
          try 
        { 

              Class.forName("com.mysql.jdbc.Driver");
        	  System.out.println("inside");
       
         conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssdi", "root", "Swetha@90");
         
          
           
  
        } 
        catch (SQLException ex) { 
            System.out.println("unable to connect "+ex.getMessage() ); 
        } 
        
    } 
    
    public int checkLogin(Login l) 
    { 
       
        try { 
            
            String query = "SELECT * FROM login where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
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
                 
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
       
    } 
    
    
}
