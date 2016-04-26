<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["AddStore"]["Store_Name"].value;
         if (x == null || x == "") {
          alert("Please provide the Store name");
         return false;         
         }

     	var x = document.forms["AddStore"]["Address"].value;
        if (x == null || x == "") {
         alert("Please provide the Store address");
        return false;         
        }
         
	 var x = document.forms["AddStore"]["location"].value;
         if (x == null || x == "") {
          alert("Please provide the Store location");
         return false;         
         }

	 var x = document.forms["AddStore"]["Phone"].value;
         if (x == null || x == "") {
          alert("Please provide the Store phone number");
         return false;         
         }

         var reg = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/; 
         var OK = reg.exec(x);  
         if (!OK)  
         {  alert("Enter a valid phone number "); return false;}  
         
	 var x = document.forms["AddStore"]["email-id"].value;
         if (x == null || x == "") {
          alert("Please provide the Store email-id");
         return false;         
         }                 
         var atpos = x.indexOf("@");
         var dotpos = x.lastIndexOf(".");
         if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
             alert("Enter a valid e-mail address");
             return false;
         }
         
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
     <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
    //    out.print("Hello, "+username);  
        }  
      %>
    <form  name = "AddStore" onsubmit = "return validateForm()" method = "post" action="addstoreController">
       
           <table align="center" >
               <center><h1>ADD STORE</h1></center>
               <tr>
               <br></br>
               <td>ID:</td>
               <% int storeid = 0;
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select max(storeId)  from store");
while (rs.next())
{    storeid = rs.getInt(1);
	 storeid += 1;
	}
out.print("<td><input type='text' name='store_id' value='"+storeid+"' readonly/></td>");
%>
               
               
               </tr><td></td><td></td>
               <tr>
                   <td>NAME:</td>
                   <td><input type="text" name="Store_Name" value="" /></td>
                 </tr><td></td><td></td>
                 <tr>
               <td>ADDRESS:</td>
               <td><input type="text" name="Address" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td>LOCATION:</td>
               <td><input type="text" name="location" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td>PHONE NO:</td>
               <td><input type="text" name="Phone" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td>E-MAIL ID:</td>
               <td><input type="text" name="email-id" value="" /></td>
               </tr><td></td>
                 
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <br></br>
           <td><center><input type="submit" value="ADD" /></td></center>
</form>
<br />
  <center> <a href = "AdminHome.jsp"><button>CANCEL</button></a></center>
  </div>

<div id="left">
    <div class="pad">
 <br />	 
	  <a href="AddStore.jsp"><button>ADD STORE</button></a>
    <br /><br />
      	
      <!--  <button style="color:blue;border-radius:10px;height:30px; width: 150px">-->
      <form method = "post" action="viewStoresController">
      <input type="submit" value="MANAGE STORE" /></form>
  
    <br />
<a href="AddProduct.jsp"><button>ADD PRODUCT</button></a>      	
      
    <br /><br />
 	<a href="ResetPassword.jsp"><button>CHANGE PASSWORD</button></a>
  </div>
  <br />
</div>
  
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="AdminHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
