<%@page import="java.awt.Checkbox"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.TechOrders"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>

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
         <form name = "SelectStore" onsubmit = "return validateForm()" method = "post" action="TechUpdateOrderController">
             
                   <center>
               <h1>Update Order</h1>
               <br></br>
           <div style="height:200px; overflow:auto"> 
               <table>
            

               <tr>
                   <th>Order Id</th>
                   
                   <th>Product name</th>
                   
                  <th>Company</th>
                   <th>Description</th>
                   <th>Customer Name</th>
                   <th>Customer Phone</th>
                   <th>Customer Email id</th>     
                    
                
               </tr>

              
                   <% 
                   
                   ArrayList<TechOrders> ol = new ArrayList();
                   ol  = (ArrayList<TechOrders>) request.getAttribute("techorders");
                   if(ol!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<ol.size();i++)
                   {
                    	   TechOrders t = ol.get(i);

                   out.print("<tr>");
                   out.print("<td><input type='Checkbox'id='Select'></td>");
                   	 out.print("<td> <input type='text' name='Order id' value='"+t.getOrderid()+"' />  </td>");
                   //out.print("<td> <input type='text' name='product id' value='"+t.getProdId()+"' />   </td>");
                   out.print("<td> <input type='text' name='product' value='"+t.getProdname()+"' />   </td>");
                   //out.print("<td> <input type='text' name='make' value='"+t.getMake()+"' />   </td>");
                   out.print("<td> <input type='text' name='company' value='"+t.getCompany()+"' />   </td>");
                   out.print("<td> <input type='text' name='description' value='"+t.getDescription()+"' />   </td>");
                   out.print("<td> <input type='text' name='customername' value='"+t.getCustname()+"' />   </td>");
                     out.print("<td> <input type='text' name='customerphone' value='"+t.getCustphone()+"' />   </td>");
                     out.print("<td> <input type='text' name='customeremail' value='"+t.getCustemail()+"' />   </td>");
                     
                     out.print("</tr>");
                   }}        %>

              </table>
</div>                
            
           <table align="center" >
        
                   <td>Select the order Id :</td>
                   <%
    			try{
    				String username=null;
Class.forName("com.mysql.jdbc.Driver");
Connection connection =          DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
if(session!=null){  
    username=(String)session.getAttribute("username");
    
}
String query1 = "select techId from technician where techName=? ;"; 
PreparedStatement statement1 = connection.prepareStatement(query1) ;
statement1.setString(1, username);
resultset2  = statement1.executeQuery();
int techid=0;
%>
<%  while(resultset2.next()){ %>
            <% techid = resultset2.getInt(1);%>
        <% } %>

<%
String query = "select orderId from orderdetails where tech_id=? ;";
       PreparedStatement statement2 = connection.prepareStatement(query) ;
       
       
	   statement2.setInt(1, techid);
	   
	   resultset1 =statement2.executeQuery() ;
%>
		<td><select name = "orderId">
        <%  while(resultset1.next()){ %>
            <option ><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
        </td>
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
          
                   </table>
               <table> <tr>   
                   <br></br>
                   <td><input type="submit" name="update" value="UPDATE"   /></td>
    				
    				</tr>
    				
                   
           </table>         
           </center>
  
           
                   
       </form>
       <br />
  <center> <a href = "TechnicianHome.jsp"><button>CANCEL</button></a></center>
  </div>
         
  
               
  
<div id="left">
    <div class="pad">
 <br />	 
	  <form method = "post" action="TechnicianViewOrdersController">
      <input type="submit" value="MANAGE ORDERS" /></form>
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
      %></label><a href="TechnicianHome.jsp"> - Home</a> - <a href="logoutcontroller">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
