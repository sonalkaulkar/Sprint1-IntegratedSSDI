<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["AddTechnician"]["username"].value;
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

         var x = document.forms["AddTechnician"]["tech_phone_no"].value;
         if (x == null || x == "") {
          alert("Please provide the phone number");
         return false;         
         }
         
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
               <td><input type="text" name="username" value="" /></td>
               </tr><td></td><td></td>
               <tr>
               <tr>
               <td>ID:</td>
               <td><input type="text" name="techId" value="" /></td>
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
               <tr>
               <td>STORE ID:</td>
               <td><input type="text" name="store_id" value="" /></td>
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
    <a href="AddTechnician.jsp"><button style="color:blue;border-radius:10px; height:30px; width: 135px">ADD TECHNICIAN</button></a>
    <br /><br />
      <a href="DeleteTechnician.jsp"><button style="color:blue;border-radius:10px;height:30px; width: 150px">DELETE TECHNICIAN</button></a>
    <br /><br />
    <a href="AddDeliverystaff.jsp"><button style="color:blue;border-radius:10px; height:30px; width: 160px">ADD DELIVERY STAFF</button></a>
    <br /><br />
      <a href="DeleteDeliveryStaff.jsp"><button style="color:blue;border-radius:10px;height:30px; width: 180px">DELETE DELIVERY STAFF</button></a>
    <br /><br />
  </div>
</div>
<div id="footer">
    <div id="r"> &copy; Copyright 2016, Your Website - <a href="StrManagerHome.jsp">Home</a> - <a href="InitialPage.jsp">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>