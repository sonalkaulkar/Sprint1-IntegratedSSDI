
<%@page import="model.Store"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["UpdateStore"]["storeId"].value;
         if (x == null || x == "") {
          alert("Please provide the Store Id");
         return false;         
         }
         
         var x = document.forms["UpdateStore"]["storeName"].value;
         if (x == null || x == "") {
          alert("Please provide the Store name");
         return false;         
         }

         var x = document.forms["UpdateStore"]["storeAdd"].value;
         if (x == null || x == "") {
          alert("Please provide the Store address");
         return false;         
         }

         var x = document.forms["UpdateStore"]["storeLocation"].value;
         if (x == null || x == "") {
          alert("Please provide the Store location");
         return false;         
         }

         var x = document.forms["UpdateStore"]["store_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the Store phone no");
         return false;         
         }

         var x = document.forms["UpdateStore"]["store_email_id"].value;
         if (x == null || x == "") {
          alert("Please provide the Store email-id");
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
     <form  name = "UpdateStore" onsubmit = "return validateForm()" method = "post" action="updatestorecontroller">
        
 
           <table align="center" >
               <center><h1>STORE DETAILS</h1></center>
              
  <tr>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;STORE ID:</td>
        		<% Store s = (Store) request.getAttribute("storedet");
                out.print("<td> <input type='text' name='storeId' value='"+s.getStoreId()+"' />  </td>"); 
               
              
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NAME:</td>");
                out.print("<td><input type='text' name='StoreName' value='"+s.getStoreName()+"' />  </td>"); 
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ADDRESS:</td>");
                out.print("<td><input type='text' name='storeAdd' value='"+s.getStoreAdd()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOCATION:</td>");
                out.print("<td><input type='text' name='StoreLocation' value='"+s.getStoreLocation()+"' />  </td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PHONE NO:</td>");
                out.print("<td><input type='text' name='store_phone_no' value='"+s.getStore_Phone_No()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print("<tr>");
                out.print("<tr>");
                out.print("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E-MAIL ID:</td>");
                out.print("<td><input type='text' name='store_email_id' value='"+s.getStore_Email_Id()+"' /></td>");
                out.print("</tr><td></td><td></td>");
                out.print(" <tr>");
                 
                out.print("<td></td><td></td>");
                              
               %>
               
           </tr>
           </table>
           <td><center><input type="submit" value="SUBMIT" /></td></center>
</form>
  </div>

  <div id="left">
    <div class="pad">
      <br /><br />
    <a href="AddStore.jsp"><button style="height:30px; width: 90px">ADD STORE</button></a>
    <br /><br /><br />
     <form method = "post" action="viewStoresController">
      <input type="submit" value="Manage Store" /></form>
    <br /><br />
  </div>
</div>
<div id="footer">
    <div id="r"> &copy; Copyright 2016, Your Website - <a href="AdminHome.jsp">Home</a> - <a href="InitialPage.jsp">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
