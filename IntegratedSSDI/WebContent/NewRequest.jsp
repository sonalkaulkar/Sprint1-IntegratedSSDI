<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<%ResultSet resultset3 =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ONLINE SERVICING APPLICAITON</title>
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
  
    <form  name = "NewRequest"  method = "post" action="searchcontroller">
       
       <center><h1>NEW SERVICE REQUEST</h1></center>
               <tr>
                <br></br>      
           <table align="center" >
               
               <td>PRODUCT:</td>
               
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");

       Statement statement = connection.createStatement() ;
       resultset1 =statement.executeQuery("select distinct(description) from product") ;
%>
		<td><select name = "Product">
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
               </tr><td></td><td></td>
               <tr>
                   <td>COMPANY:</td>
                   
                 
                 <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");

       Statement statement = connection.createStatement() ;

       resultset2 =statement.executeQuery("select distinct(company) from product") ;
%>
		<td><select name = "Company">
        <%  while(resultset2.next()){ %>
            <option><%= resultset2.getString(1)%></option>
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
                 </tr><td></td><td></td>
                 <tr>
               <td>LOCATION:</td>
               
               
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");

       Statement statement = connection.createStatement() ;

       resultset3 =statement.executeQuery("select distinct(storeLocation) from store") ;
%>
		<td><select name = "location">
        <%  while(resultset3.next()){ %>
            <option><%= resultset3.getString(1)%></option>
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
               </tr><td></td><td></td>
               <tr>
                 
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
           <br></br>
           <td><center><input type="submit" value="SEARCH" /></center></td>
      <!-- <input type="submit" value="SEARCH" /> -->      
</form>
<br />
  <center> <a href = "CustomerHome.jsp"><button>CANCEL</button></a></center>
     
  </div>
  
  

<div id="left">
    <div class="pad">
      <br /><br />
    <a href="NewRequest.jsp"><button>NEW REQUEST</button></a>
    <br /><br />
      <form method = "post" action="ViewHistoryController">
      <input type="submit" value="VIEW HISTORY" /></form>
    <br />
    <a href="ResetPassword.jsp"><button ">CHANGE PASSWORD</button></a>
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
