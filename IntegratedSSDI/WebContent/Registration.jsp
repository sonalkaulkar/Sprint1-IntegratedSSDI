<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["Registration"]["customerName"].value;
         if (x == null || x == "") {
          alert("Please provide the name");
         return false;         
         }

         var x = document.forms["Registration"]["location"].value;
         if (x == null || x == "") {
          alert("Please provide the location");
         return false;         
         }

         var x = document.forms["Registration"]["customer_email_id"].value;
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
         
	 	 var x = document.forms["Registration"]["customer_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the phone number");
         return false;         
         }
         var reg = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/; 
         var OK = reg.exec(x);  
         if (!OK)  
         {  alert("Enter a valid 10 digit phone number"); return false;} 
         var x = document.forms["Registration"]["customer_add"].value;
         if (x == null || x == "") {
          alert("Please provide the address");
         return false;         
         }
         var x = document.forms["Registration"]["customer_username"].value;
         if (x == null || x == "") {
          alert("Please provide the username");
         return false;         
         }
         var x = document.forms["Registration"]["customer_password"].value;
         if (x == null || x == "") {
          alert("Please provide the password");
         return false;         
         }
         var x1 = document.forms["Registration"]["customer_password"].value;
         var x2 = document.forms["Registration"]["confirm_password"].value;
         if (x1!=x2) {
             alert("Password and confirm password should match");
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
    <form  name = "Registration" onsubmit = "return validateForm()" method = "post" action="registrationController">
       
           <table align="center" >
               <center><h1>REGISTRATION</h1></center>
               <tr>
               <br></br>
               <td>ID:</td>
                      <% int customerid = 0;
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select max(customerId)  from customer");
while (rs.next())
{    customerid = rs.getInt(1);
	 customerid += 1;
	}
out.print("<td><input type='text' name='customerId' value='"+customerid+"' readonly /></td>");
%>
           
               </tr><td></td><td></td>
               <tr>
                   <td>NAME:</td>
                   <td><input type="text" name="customerName" value="" /></td>
                 </tr><td></td><td></td>
                 <tr>
               <td>LOCATION:</td>
               <td><input type="text" name="location" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td>E-MAIL ID:</td>
               <td><input type="text" name="customer_email_id" value="" /></td>
               </tr><td></td>
               <tr>
               <td>PHONE NO:</td>
               <td><input type="text" name="customer_phone_no" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td>ADDRESS:</td>
               <td><input type="text" name="customer_add" value="" /></td>
               </tr><td></td><td></td>
               <tr>
                 <tr>
               <td>USERNAME:</td>
               <td><input type="text" name="customer_username" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <tr>
               <td>PASSWORD:</td>
               <td><input type="password" name="customer_password" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td></td><td></td>
                <tr>
               <td>CONFIRM PASSWORD:</td>
               <td><input type="password" name="confirm_password" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <td></td><td></td>
               
               
           </tr>
           </table>
           <br></br>
           <td><center><input type="submit" value="REGISTER" /></td></center>
</form>
<br />
  <center> <a href = "InitialPage.jsp"><button>CANCEL</button></a></center>
  </div>

<div id="left">
    <div class="pad">
      <img src="images/homepageimg2.jpg" height="700" width="200" alt="" />
    <div id="leftend"></div>
  </div>
</div>
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="InitialPage.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
