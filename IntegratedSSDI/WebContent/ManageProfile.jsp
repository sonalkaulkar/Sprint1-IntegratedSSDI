
<%@page import="model.orderObserve.Observer.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["ManageProfile"]["customerId"].value;
         if (x == null || x == "") {
          alert("Please provide the Customer Id");
         return false;         
         }
         
         var x = document.forms["ManageProfile"]["customerName"].value;
         if (x == null || x == "") {
          alert("Please provide the Customer name");
         return false;         
         }

         var x = document.forms["ManageProfile"]["location"].value;
         if (x == null || x == "") {
          alert("Please provide the location");
         return false;         
         }

         var x = document.forms["ManageProfile"]["customer_email_id"].value;
         if (x == null || x == "") {
          alert("Please provide the email id");
         return false;         
         }
         var atpos = x.indexOf("@");
         var dotpos = x.lastIndexOf(".");
         if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
             alert("Enter a valid e-mail address");
             return false;
         }
         var x = document.forms["ManageProfile"]["customer_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the phone no");
         return false;         
         }
         var reg = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/; 
         var OK = reg.exec(x);  
         if (!OK)  
         {  alert("Enter a valid phone number "); return false;} 
       
         var x = document.forms["ManageProfile"]["customer_add"].value;
         if (x == null || x == "") {
          alert("Please provide the address");
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
     <form  name = "ManageProfile" onsubmit = "return validateForm()" method = "post" action="manageprofilecontroller">
        
 
           <table align="center" >
               <center><h1>Manage Profile</h1></center>
              
  <tr>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CUSTOMER ID:</td>
        		<% Customer c = (Customer) request.getAttribute("custdet");
                out.print("<td> <input type='text' name='customerId' value='"+c.getCustomerId()+"' />  </td>"); 
               
              
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NAME:</td>");
                out.print("<td><input type='text' name='customerName' value='"+c.getCustomerName()+"' />  </td>"); 
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOCATION:</td>");
                out.print("<td><input type='text' name='location' value='"+c.getLocation()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EMAIL-ID:</td>");
                out.print("<td><input type='text' name='customer_email_id' value='"+c.getCustomer_email_id()+"' />  </td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PHONE NO:</td>");
                out.print("<td><input type='text' name='customer_phone_no' value='"+c.getCustomer_phone_no()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ADDRESS:</td>");
                out.print("<td><input type='text' name='customer_add' value='"+c.getCustomer_address()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print(" <tr>");
                 
                out.print("<td></td><td></td>");
                              
               %>
               
           </tr>
           </table>
           <td><center><input type="submit" value="SUBMIT" /></td></center>
</form>
<br />
  <center> <a href = "CustomerHome.jsp"><button>CANCEL</button></a></center>
  </div>

  <div id="left">
    <div class="pad">
      <br /><br />
    <a href="NewRequest.jsp"><button>NEW REQUEST</button></a>
    <br /><br />
      <form method = "post" action="ViewHistoryController">
      <input type="submit" value="VIEW HISTORY" /></form>
    <br />
    <a href="ResetPassword.jsp"><button ">CHANGE PASSWORD</button></a>
    <br /><br />
        <form method = "post" action="loadprofilecontroller">
      <input type="submit" value="MANAGE PROFILE" /></form>
  
    <br /><br />
          </div>
  <br />
</div>
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="CustomerHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
