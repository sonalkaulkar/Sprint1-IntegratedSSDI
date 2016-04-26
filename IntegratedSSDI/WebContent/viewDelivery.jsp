<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.deliveryStaff"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online servicing application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
<div id="content">
  <div id="header">
    <div class="left">
      <h1>Electronic goods service @ your doorstep !!!</h1>
      
    </div>
 
  <div id="main">
  
    <h3>ONLINE SERVICING APPLICATION</h3> 
  </div>
  </div>
  
  <div id="main">
   
    <form >
             
                   <center>
               <h1>Delivery Staff Details</h1>
          <div style="height:200px; overflow:auto">	
               <table>
              

               <tr>
                   <th>Delivery Staff Id</th>
                   <th>Delivery Staff Name</th>
                    <th>Delivery Email Id </th>
                	  <th>Delivery Phone Number </th>
               </tr>

              
                   <% 
                   
                   ArrayList<deliveryStaff> dl = new ArrayList();
                   dl  = (ArrayList<deliveryStaff>) request.getAttribute("delivery");
                   if(dl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<dl.size();i++)
                   {
                       deliveryStaff d = dl.get(i);

                   out.print("<tr>");
                   out.print("<td> <input type='text' name='Delid' value='"+d.getDeliveryId()+"' />  </td>");
                   out.print("<td> <input type='text' name='Delname' value='"+d.getDeliveryName()+"' />   </td>");
                    out.print("<td> <input type='text' name='Del_email_id' value='"+d.getDelivery_email_id()+"' />   </td>");
                    out.print("<td> <input type='text' name='Del_phone_no' value='"+d.getDelivery_phone_no()+"' />   </td>");
                    
                    out.print("</tr>");
                   }}        %>
              </table>
              </div>
        <table><tr>
                   <td>Enter the Delivery Staff  Id :
                 
                    <%
                    
    			try{ String username = "";
    				 if(session!=null){  
                        username=(String)session.getAttribute("username");  
                           
                        //out.print("Hello, "+username);
                        
                         } 
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
String query = "select storeid from store where manager_username = ?";
int store_id = 0;
PreparedStatement stmt = null;

stmt = connection.prepareStatement(query);
stmt.setString(1,username);
ResultSet rs = stmt.executeQuery();
if (rs.next())
{
	store_id = rs.getInt(1);
}
query = "select deliveryId  from deliverystaff where store_id = ?;";
       PreparedStatement statement = connection.prepareStatement(query) ;
       
       
	   statement.setInt(1, store_id);
	  
	   resultset1 =statement.executeQuery() ;
%>
		<td><select name = "delId">
        <%  while(resultset1.next()){ %>
            <option ><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
        </td>
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
           </tr></table>
               <table> <tr>   
                 
    				<td><input type="submit" name="delete" value="Delete Delivery Staff"  onclick="form.action='deletedeliverycontroller';"/></td>
    			
    				</tr>
           </table>         
           </center>
                   
       </form>
       <br />
  <center> <a href = "StrManagerHome.jsp"><button>CANCEL</button></a></center>
  </div>

 <div id="left">
    <div class="pad">
    <br />
   <a href="AddTechnician.jsp"><button>ADD TECHNICIAN</button></a>
    <br /><br />
      <form method = "post" action="viewtechniciancontroller">
      <input type="submit" value="DELETE TECHNICIAN" /></form>
    <br />
    <a href="AddDeliverystaff.jsp"><button>ADD DELIVERY STAFF</button></a>
    <br /><br />
       <form method = "post" action="ViewDeliveryStaffController">
      <input type="submit" value="DELETE DELIVERY STAFF" /></form>
    <br />
    <a href="ResetPassword.jsp"><button ">CHANGE PASSWORD</button></a>
    <br /><br/>
       <form method = "post" action="ViewStoreordersController">
      <input type="submit" value="MONITOR ORDERS" /></form>
    <br />
    <a href="TransferOrdersTo.jsp"><button>TRANSFER ORDERS</button></a>
    <br /><br />  
    
  </div>
 
</div> 
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="StrManagerHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
