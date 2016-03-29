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

	 var x = document.forms["AddStore"]["email-id"].value;
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
    <form  name = "AddStore" onsubmit = "return validateForm()" method = "post" action="addstoreController">
       
           <table align="center" >
               <center><h1>ADD STORE</h1></center>
               <tr>
               <td>ID:</td>
               <td><input type="text" name="store_id" value="" /></td>
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
           <td><center><input type="submit" value="ADD" /></td></center>
</form>
  </div>

<div id="left">
    <div class="pad">
 <br />	 
	  <a href="AddStore.jsp"><button style="height:30px; width: 100px">Add Store</button></a>
    <br /><br />
      	
      <!--  <button style="color:blue;border-radius:10px;height:30px; width: 150px">-->
      <form method = "post" action="viewStoresController">
      <input type="submit" value="Manage Store" /></form>
      
    <br /><br />
    <br /><br />
    <br /><br />
    <br /><br />
    <br /><br />
 	
  </div>
  <br />
</div>
  
<div id="footer">
    <div id="r"> &copy; Copyright 2016, Your Website - <a href="AdminHome.jsp">Home</a> - <a href="InitialPage.jsp">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
