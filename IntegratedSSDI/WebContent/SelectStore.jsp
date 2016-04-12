<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<%@page import="model.Store"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["SelectStore"]["storeId"].value;
         if (x == null || x == "") {
          alert("Please provide the Store Id");
         return false;         
         }
         
         var x = document.forms["SelectStore"]["description"].value;
         if (x == null || x == "") {
          alert("Please provide the description");
         return false;         
         }

        }
        </script>

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
    
    <form  name = "SelectStore" onsubmit = "return validateForm()" method = "post" action="newrequestcontroller">
            <%String product = (String)request.getAttribute("product");
            String company = (String)request.getAttribute("company");
            String location = (String)request.getAttribute("location");
            out.print("<input type='hidden' name='product' value='"+product+"' />");
            out.print("<input type='hidden' name='company' value='"+company+"' />");
            out.print("<input type='hidden' name='location' value='"+location+"' />");      
            %> 
                   <center>
               <h1>View Store Details</h1>
               <br></br>
       			<div style="height:150px; overflow:auto">
               <table>
              
			
               <tr>
                   <th>Store Id</th>
                   <th>Store Name</th>
                    <th>Store Location </th>
                    <th>Store address </th>
                    <th>Store phone </th>
                                    
               </tr>
               
                   <% 
                   
                   ArrayList<Store> sl = new ArrayList();
                   sl  = (ArrayList<Store>) request.getAttribute("store");
                   if(sl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<sl.size();i++)
                   {
                       Store s = sl.get(i);

                   out.print("<tr>");
                   out.print("<td> <input type='text' name='storeid' value='"+s.getStoreId()+"' />  </td>");
                   out.print("<td> <input type='text' name='sname' value='"+s.getStoreName()+"' />   </td>");
                    out.print("<td> <input type='text' name='slocation' value='"+s.getStoreLocation()+"' />   </td>");
                    out.print("<td> <input type='text' name='address' value='"+s.getStoreAdd()+"' />   </td>");
                    out.print("<td> <input type='text' name='phone' value='"+s.getStore_Phone_No()+"' />   </td>");
                    out.print("</tr>");
                   }}        %>
                   
              </table>
              </div>
        <table align="center" >
        
                   <td>Enter the store Id :</td>
                   <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
String query = "select SP.storeId from storeproduct SP , store S  where    S.storeId = SP.storeId and  storeLocation = ? and prodId in (select prodId from product where company  = ? and description = ? ) ;";
       PreparedStatement statement = connection.prepareStatement(query) ;
       
       
	   statement.setString(1, location);
	   statement.setString(2, company);
	   statement.setString(3, product);
	   resultset1 =statement.executeQuery() ;
%>
		<td><select name = "storeId">
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
          
                   <tr><td>Enter the description :
                   <textarea id="desc" name="description" ></textarea></td>
           </tr></table>
               <table> <tr>   
                   <br></br>
                   <td><input type="submit" name="update" value="Place request"   /></td>
    				
    				</tr>
    				
                   
           </table>         
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
