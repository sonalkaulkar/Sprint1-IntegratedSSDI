<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PickUpOrder"%>

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



function valthisform()
{
    var checkboxs=document.getElementsByName("selectedItems");
    var okay=false;
    for(var i=0,l=checkboxs.length;i<l;i++)
    {
        if(checkboxs[i].checked)
        {
            okay=true;
            break;
        }
    }
    if(okay)
    	{
    	//alert("Thank you for checking a checkbox");
    	document.getElementById('updt').disabled = false;
    	    	return true
    	}
    else 
    	{//alert("Please check a checkbox");
    	document.getElementById('updt').disabled = true;
    	return false
    	}
}
   
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
         <form  id = "updateorder" method = "post" action = "UpdateStatusPickUp" >
             
                   <center>
               <h1>ORDERS TO BE PICKED UP</h1>
               <br></br>
           <div style="height:200px; overflow:auto"> 
               <table>
            

               <tr>
                   <th>Orders</th>
                   <th>Order Id</th>
                   <th>Customer Name</th>
                   <th>Customer Phone</th>
                   <th>Customer Address</th>
                   <th>Customer Email id</th>
                   <th>Product</th>
                    
                
               </tr>

              
                   <% 
                   
                   ArrayList<PickUpOrder> sl = new ArrayList();
                   sl  = (ArrayList<PickUpOrder>) request.getAttribute("order");
                   if(sl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<sl.size();i++)
                   {
                    	   PickUpOrder s = sl.get(i);

				

                   out.print("<tr>");
                   %>
                  
                   <td align="center">  
                   <input type="checkbox" name="selectedItems"    
                       value="<%=s.getOrderId()%>" onclick="  valthisform()" />  
               </td>
               <%
                   out.print("<td> <input type='text' name='order_"+s.getOrderId()+"' value='"+s.getOrderId()+"' />  </td>");
                   out.print("<td> <input type='text' name='customername' value='"+s.getCust_name()+"' />   </td>");
                     out.print("<td> <input type='text' name='customerphone' value='"+s.getCust_phone_no()+"' />   </td>");
                     out.print("<td> <input type='text' name='customeraddress' value='"+s.getCust_address()+"' />   </td>");
                     out.print("<td> <input type='text' name='customeremail' value='"+s.getCust_emailid()+"' />   </td>");
                     out.print("<td> <input type='text' name='product' value='"+s.getProduct()+"' />   </td>");
                     out.print("</tr>");
                   }}        %>

              </table>
</div>                  
<br></br>
  <input type="submit" id = "updt" value="UPDATE"   onclick=" return valthisform()" />
   
           </center>
                   
       </form>
       <br />
  <center> <a href = "DeliveryStaffHome.jsp"><button>CANCEL</button></a></center>
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
