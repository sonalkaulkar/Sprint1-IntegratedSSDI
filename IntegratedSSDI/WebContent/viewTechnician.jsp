<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.technician"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online servicing application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
        function validateForm () {
         
         var x = document.forms["Technician"]["techId"].value;
         if (x == null || x == "") {
          alert("Please provide the Id");
         return false;         
         }

        }
        </script>

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
   
         <form  name = "Technician" onsubmit = "return validateForm()" method = "post" action="DeleteTechnicianController">
                   <center>
               <h1>Technician Details</h1>
          <div style="height:200px; overflow:auto">	
               <table>
              

               <tr>
                   <th>Technician Id</th>
                   <th>Technician Name</th>
                    <th>Technician Phone Number </th>
                    <th>Technician Email Id  </th> 
                
               </tr>

              
                   <% 
                   
                   ArrayList<technician> tl = new ArrayList();
                   tl  = (ArrayList<technician>) request.getAttribute("technician");
                   if(tl!= null)
                   {
                      
                       //out.print(tl.le);
                       for(int i = 0;i<tl.size();i++)
                   {
                       technician t = tl.get(i);

                   out.print("<tr>");
                   out.print("<td> <input type='text' name='techid' value='"+t.getTechId()+"' />  </td>");
                   out.print("<td> <input type='text' name='techname' value='"+t.getTechName()+"' />   </td>");
                    out.print("<td> <input type='text' name='tech_email_id' value='"+t.getTech_email_id()+"' />   </td>");
                    out.print("<td> <input type='text' name='tech_phone_no' value='"+t.getTech_phone_no()+"' />   </td>");
                    
                    out.print("</tr>");
                   }}        %>
              </table>
              </div>
        <table><tr>
                   <td>Enter the Technician Id :
                 
                     <%
                    
    			try{ String username = "";
    				 if(session!=null){  
                        username=(String)session.getAttribute("username");  
                           
                        //out.print("Hello, "+username);
                        
                         } 
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ssdi","root","UnccSonal11");
String query = "select storeid from store where manager_username = ?";
int store_id = 0;
PreparedStatement stmt = null;

stmt = connection.prepareStatement(query);
stmt.setString(1,username);
ResultSet rs = stmt.executeQuery();
if (rs.next())
{
	store_id = rs.getInt(1);
}
query = "select techId  from technician where store_id = ? and  techId <> '1';";
       PreparedStatement statement = connection.prepareStatement(query) ;
       
       
	   statement.setInt(1, store_id);
	  
	   resultset1 =statement.executeQuery() ;
%>
		<td><select name = "techId">
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
                   
                   
           </tr></table>
               <table> <tr>   
                 
    				<td><input type="submit" name="delete" value="Delete Technician"  onclick="form.action='deletetechniciancontroller';"/></td>
    			
    				</tr>
           </table>         
           </center>
                   
       </form>
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
