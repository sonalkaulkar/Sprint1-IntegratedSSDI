

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online servicing application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function(){

$(".slidingDiv").hide();
$(".show_hide").show();

$('.show_hide').click(function(){
$(".slidingDiv").slideToggle();
});

});

</script>
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
    
    <center><h1>Hello Delivery Staff !! Welcome to our Online Servicing Application !! Happy Servicing !!</h1></center>
               <br></br>
  </div>
         
  
<div id="left">
    <div class="pad">
 <br />	 
	<form method = "post" action="viewpickupcontroller">
      <input type="submit" value="VIEW PICKUP ORDERS" /></form>
    <br />
      	
   <form method = "post" action="viewdeliveredcontroller">
      <input type="submit" value="VIEW DELIVERY ORDERS" /></form>
    <br />
      
    <!--  <button style="color:blue;border-radius:10px;height:30px; width: 150px">-->
    <!--   <form method = "post" action="viewStoresController">
      <input type="submit" value="Manage Store" /></form> -->
      
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
      %></label><a href="DeliveryStaffHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
