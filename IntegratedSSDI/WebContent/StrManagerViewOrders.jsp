<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.orderObserve.observable.orderDetails"%>
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
      <form >
             
                   <center>
               <h1>Order List</h1>
               </br>
               <div style="height:200px; overflow:auto">
               <table>
              

               <tr>
                   <th>Order Id</th>
                   <th>Date of Order</th>
                    <th>Product Make </th>
                    <th>Order Status</th>
                    <th>Payment Status</th>
                    <th>Description</th>
                    <th>Delivery Id  </th>
                
               </tr>

              
                   <% 
                   
                   ArrayList<orderDetails> sl = new ArrayList();
                   sl  = (ArrayList<orderDetails>) request.getAttribute("order");
                   if(sl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<sl.size();i++)
                   {
                    	   orderDetails s = sl.get(i);

                   out.print("<tr>");
                   out.print("<td> <input type='text' name='Order id' value='"+s.getOrderId()+"' />  </td>");
                   out.print("<td> <input type='text' name='date' value='"+s.getDate_of_order()+"' />   </td>");
                    out.print("<td> <input type='text' name='make' value='"+s.getMake()+"' />   </td>");
                    
                    out.print("<td> <input type='text' name='orderstatus' value='"+s.getOrder_status()+"' />   </td>");
                     out.print("<td> <input type='text' name='paymentmake' value='"+s.getPayment_status()+"' />   </td>");
                     out.print("<td> <input type='text' name='desc' value='"+s.getDescription()+"' />   </td>");
                     out.print("<td> <input type='text' name='deliveryid' value='"+s.getDelivery_id()+"' />   </td>");
                   
                    out.print("</tr>");
                   }}        %>
                   
              </table>
            </div>
           </center>
                   
       </form>
       <br />
  <center> <a href = "StrManagerHome.jsp"><button>CANCEL</button></a></center>
  </div>
  
<div id="left">
    <div class="pad">
    <br />
   <a href="AddTechnician.jsp"><button>ADD TECHNICIAN</button></a>
    <br /><br />
      <form method = "post" action="viewtechniciancontroller">
      <input type="submit" value="DELETE TECHNICIAN" /></form>
    <br />
    <a href="AddDeliverystaff.jsp"><button>ADD DELIVERY STAFF</button></a>
    <br /><br />
       <form method = "post" action="ViewDeliveryStaffController">
      <input type="submit" value="DELETE DELIVERY STAFF" /></form>
    <br />
    <a href="ResetPassword.jsp"><button ">CHANGE PASSWORD</button></a>
    <br /><br/>
       <form method = "post" action="ViewStoreordersController">
      <input type="submit" value="MONITOR ORDERS" /></form>
    
    <br />
    <a href="TransferOrdersTo.jsp"><button>TRANSFER ORDERS</button></a>
    <br /><br />  
    
  </div>
 
</div>  
<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="StrManagerHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
