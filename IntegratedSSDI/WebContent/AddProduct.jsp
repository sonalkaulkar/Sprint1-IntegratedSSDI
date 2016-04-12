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
     <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
        out.print("Hello, "+username);  
        }  
      %>
   <form  name = "AddProduct"  method = "post" action="addProductController">
       
           <table align="center" >
               <center><h1>ADD PRODUCTS</h1></center>
               <tr>
               <td>Product Name:</td>
              <td><input type="text" name="Product_Name" value="" /></td>
              <td> (Computer,Laptop,Refrigerator,AC)</td><td></td><td></td>
               </tr>
                   <td>Company:</td>
                   <td><input type="text" name="Company_Name" value="" /></td>
                     <td> (Dell,Lenovo,LG)</td>
                 </tr><td></td><td></td>
                 <tr>
                 <td>
                 <input  type = "hidden"  name = "store_id" value="<%=session.getAttribute("store_id")%>" /> 
        
                 </td>
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
 	<a href="ResetPassword.jsp"><button style="height:30px; width: 150px">Reset Password</button></a>
  </div>
  <br />
</div>

<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="AdminHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
