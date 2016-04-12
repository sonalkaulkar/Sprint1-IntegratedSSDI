<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online servicing application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["resetpassword"]["old_password"].value;
         if (x == null || x == "") {
          alert("Please provide the Old Password");
         return false;         
         }
         
         var x = document.forms["resetpassword"]["new_password"].value;
         if (x == null || x == "") {
          alert("Please provide the New Password");
         return false;         
         }
         
         var x = document.forms["resetpassword"]["confirm_password"].value;
         if (x == null || x == "") {
          alert("Please Confirm the New Password");
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
     
     <form  name = "resetpassword" onsubmit = "return validateForm()" method = "post" action="resetpasswordcontroller">
       
           <table align="center" >
               <center><h1>CHANGE PASSWORD</h1></center>
               <tr>
               <br></br>
               <td>OLD PASSWORD:</td>
               <td><input type="password" name="old_password" value="" /></td>
               </tr>
               <tr>
                   <td>NEW PASSWORD:</td>
                   <td><input type="password" name="new_password" value="" /></td>
                 </tr>
               <tr>
                   <td>CONFIRM PASSWORD:</td>
                   <td><input type="password" name="confirm_password" value="" /></td>
                 </tr>
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <br></br>
           <td><center><input type="submit" value="SUBMIT" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="RESET" /></td></center>
         
</form>
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
