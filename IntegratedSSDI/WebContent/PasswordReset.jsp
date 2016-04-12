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
     
   <h1 style = "color:red;"><center> <% String str = (String)request.getAttribute("msg");
   if ( !str.equals(null) ) {out.println(str);}%></center></h1><br /><br />
 <center><a href="InitialPage.jsp"><button>Back</button></a></center>
  </div>

  <div id="left">
    <div class="pad">
      <img src="images/homepageimg2.jpg" height="700" width="200" alt="" />
    <div id="leftend"></div>
  </div>
</div>
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> </label><a href="InitialPage.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
