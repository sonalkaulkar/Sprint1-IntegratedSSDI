<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["AddTechnician"]["username1"].value;
         if (x == null || x == "") {
          alert("Please provide the Username");
         return false;         
         }
         
         var x = document.forms["AddTechnician"]["techId"].value;
         if (x == null || x == "") {
          alert("Please provide the Id");
         return false;         
         }
         
         var x = document.forms["AddTechnician"]["techName"].value;
         if (x == null || x == "") {
          alert("Please provide the name");
         return false;         
         }

         var x = document.forms["AddTechnician"]["tech_email_id"].value;
         if (x == null || x == "") {
          alert("Please provide the email-id");
         return false;         
         }
         var atpos = x.indexOf("@");
         var dotpos = x.lastIndexOf(".");
         if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
             alert("Enter a valid e-mail address");
             return false;
         }
         var x = document.forms["AddTechnician"]["tech_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the phone number");
         return false;         
         }
         var reg = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/; 
         var OK = reg.exec(x);  
         if (!OK)  
         {  alert("Enter a valid phone number "); return false;} 
         
    	 var x = document.forms["AddTechnician"]["store_id"].value;
         if (x == null || x == "") {
          alert("Please provide the Store Id");
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
     
     <form  name = "AddTechnician" onsubmit = "return validateForm()" method = "post" action="addTechController">
       
           <table align="center" >
               <center><h1>ADD TECHNICIAN</h1></center>
               <tr>
               <td>USER NAME:</td>
               <td><input type="text" name="username1" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <tr>
               <td>ID:</td>
              
                <% int techid = 0;
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select max(techId) from technician");
while (rs.next())
{    techid = rs.getInt(1);
	 techid += 1;
	}
out.print("<td><input type='text' name='techId' value='"+techid+"' readonly /></td>");
%>
               </tr><td></td><td></td>
               <tr>
                   <td>NAME:</td>
                   <td><input type="text" name="techName" value="" /></td>
                 </tr><td></td><td></td>
                 <tr>
               <tr>
                   <td>E-MAIL ID:</td>
                   <td><input type="text" name="tech_email_id" value="" /></td>
                 </tr><td></td><td></td>
                 <tr>
               <td>PHONE NO:</td>
               <td><input type="text" name="tech_phone_no" value="" /></td>
               </tr><td></td><td></td>
              <!-- <tr>
                <td>STORE ID:</td>
               <td><input type="text" name="store_id" value="" /></td>
               </tr><td></td><td></td>
               <tr>
                 -->
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <td><center><input type="submit" value="REGISTER" /></td></center>
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
