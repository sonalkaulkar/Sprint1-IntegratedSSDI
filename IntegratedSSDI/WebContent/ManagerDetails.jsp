<%@page import="model.Store"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["ManagerDetails"]["username"].value;
         if (x == null || x == "") {
          alert("Please provide the Username");
         return false;         
         }

         var x = document.forms["ManagerDetails"]["manager"].value;
         if (x == null || x == "") {
          alert("Please provide the name");
         return false;         
         }

         var x = document.forms["ManagerDetails"]["manager_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the phone number");
         return false;         
         }

         var x = document.forms["ManagerDetails"]["manager_email_id"].value;
         if (x == null || x == "") {
          alert("Please provide the email-id");
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
     <form  name = "ManagerDetails" onsubmit = "return validateForm()" method = "post" action="addstoremanagercontroller">
       <%Store s = (Store) request.getAttribute("storedet"); %>
       <input type="hidden" name="store_id" value="<%=s.getStoreId() %>" />
           <table align="center" >
               <center><h1>MANAGER DETAILS</h1></center>
               <tr>
               <td>USER NAME:</td>
               <td><input type="text" name="username" value="<%=s.getManager_Username() %>" /></td>
               </tr><td></td><td></td>
               <tr>
               <tr>
               <td>NAME:</td>
               <td><input type="text" name="manager" value="<%=s.getManager() %>" /></td>
               </tr><td></td><td></td>
               <tr>
                   <td>PHONE NO:</td>
                   <td><input type="text" name="manager_phone_no" value="<%=s.getManager_Phone_No() %>" /></td>
                 </tr><td></td><td></td>
                 <tr>
               <tr>
                   <td>E-MAIL ID:</td>
                   <td><input type="text" name="manager_email_id" value="<%=s.getManager_Email_Id() %>" /></td>
                 </tr><td></td><td></td>
                 <tr>
                 
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <td><center><input type="submit" value="REGISTER" /></td></center>
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
