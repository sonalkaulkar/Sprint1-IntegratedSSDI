<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online servicing application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
     
   <h1 style="color :red;"><center> <% String str = (String)request.getAttribute("msg");
   //session.setAttribute("msg", "");
  
   if ( !str.equals(null) ) {out.println(str);}%></center></h1><br /><br />
   <center><a href="AddProduct.jsp"><input type="button" value="Add Products" name="addp"/></a></center>
  
   
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
 	<a href="ResetPassword.jsp"><button style="height:30px; width: 150px">Reset Password</button></a>
  </div>
  <br />
</div>

<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> </label><a href="AdminHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
