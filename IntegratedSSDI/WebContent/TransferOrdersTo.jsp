<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<%ResultSet resultset3 =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
       //  alert ("in here ");
            var del1 = document.getElementById('del1');
            var deliveryid1 = del1.options[del1.selectedIndex].value;
            var del2 = document.getElementById('del2');
            var deliveryid2 = del2.options[del2.selectedIndex].value;
            if (deliveryid1 ==deliveryid2 )
            	{
            	alert("From and to delivery ids cannot be the same");
            	return false;
            	}
         return true;
         
        }
        </script>
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
  
    <form  name = "NewRequest"  method = "post" action="AssignDeliveryController"  onsubmit = "return validateForm()">
       
       <center><h1>TRANSFER ORDERS</h1></center>
               <tr>
                <br></br>      
           <table align="center" >
           <td>Select the delivery id(from):</td>
               
               
               <%String username = (String) session.getAttribute("username");
    			try{
    				
    				
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
PreparedStatement st = null;
	String query = "select storeid from store where manager_username = ?";
	st = connection.prepareStatement(query);
	st.setString(1, username);
	resultset1 =st.executeQuery();
	int str_id = 0;
	if(resultset1.next())
	{
		str_id = resultset1.getInt(1);
	}
query = "select distinct(delivery_id) from orderdetails where store_id = ?";
       st = connection.prepareStatement(query) ;
       st.setInt(1, str_id);
       resultset1 =st.executeQuery() ;
       //Set the hidden del id from previous page here 
       %>
		<td><select name = "deliveryid1"  id = "del1"  required>
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

               </tr>
               <tr>
                 
               <center><td>Select the delivery id(to):</td></center>
               
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
PreparedStatement st = null;
	String query = "select storeid from store where manager_username = ?";
	st = connection.prepareStatement(query);
	st.setString(1, username);
	resultset1 =st.executeQuery();
	int str_id = 0;
	if(resultset1.next())
	{
		str_id = resultset1.getInt(1);
	}
query = "select distinct(deliveryid) from deliverystaff where store_id = ?";
       st = connection.prepareStatement(query) ;
       st.setInt(1, str_id);
       resultset1 =st.executeQuery() ;
       //Set the hidden del id from previous page here 
       %>
		<td><select name = "deliveryid2"  id = "del2" required>
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

               </tr><td></td><td></td>
               <tr>
                 
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <br></br>
           <td><center><input type="submit" value="SUBMIT"  /></center></td>
      <!-- <input type="submit" value="SEARCH" /> -->      
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
        
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="StrManagerHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
