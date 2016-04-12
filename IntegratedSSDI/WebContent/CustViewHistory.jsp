<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderHistory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
 
<div id="content">
<input type="hidden" id="thisField" name="inputName" value="hiddenValue">
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
               <h1>Order History</h1>
          <div style="height:150px; overflow:auto">
               <table>
              

               <tr>
                   <th>Order Id</th>
                   <th>Product</th>
                    <th>Company</th>
                    <th>Description</th>
                    <th>Store Name</th>
                    <th>Order Status</th>
                                    
               </tr>

              
                   <% 
                   
                   ArrayList<OrderHistory> sl = new ArrayList();
                   sl  = (ArrayList<OrderHistory>) request.getAttribute("OrderHistory");
                   
                   if(sl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<sl.size();i++)
                   {
                    	   
                    	   OrderHistory s = sl.get(i);

                   out.print("<tr>");
                   out.print("<td> <input type='text' name='Order id' value='"+s.getOrderId()+"' />  </td>");
                   out.print("<td> <input type='text' name='product' value='"+s.getProduct()+"' />   </td>");
                    out.print("<td> <input type='text' name='company' value='"+s.getCompany()+"' />   </td>");
                    out.print("<td> <input type='text' name='description' value='"+s.getDesc()+"' />  </td>");
                    out.print("<td> <input type='text' name='storename' value='"+s.getStoreName()+"' />   </td>");
                     out.print("<td> <input type='text' name='order status' value='"+s.getStatus()+"' />   </td>");
                   out.print("</tr>");
                   }}        %>
                   
              </table>
            </div>
           </center>
                   
       </form>
  </div>
  
  <div id="left">
    <div class="pad">
      <br /><br />
    <a href="NewRequest.jsp"><button>NEW REQUEST</button></a>
    <br /><br />
      <form method = "post" action="ViewHistoryController">
      <input type="submit" value="VIEW HISTORY" /></form>
    <br />
    <a href="ResetPassword.jsp"><button ">RESET PASSWORD</button></a>
    <br /><br />
        <form method = "post" action="loadprofilecontroller">
      <input type="submit" value="MANAGE PROFILE" /></form>
  
    <br /><br />
          </div>
  <br />
</div>

<div id="footer">
     <div id="r"> &copy; Copyright 2016, Your Website - <label> <%
      if(session!=null){  
        String username=(String)session.getAttribute("username");  
          
       out.print("Hello, "+username);
       
        }  
      %></label><a href="CustomerHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
