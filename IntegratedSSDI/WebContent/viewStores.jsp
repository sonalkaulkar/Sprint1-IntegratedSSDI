<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Store"%>
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
               <h1>View Store Details</h1>
          
               <table>
              

               <tr>
                   <th>Store Id</th>
                   <th>Store Name</th>
                    <th>Store Location </th>
                
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
                    
                    out.print("</tr>");
                   }}        %>
              </table>
        <table><tr>
                   <td>Enter the store Id :
                   <input type ="text" name="storeId" /></td>
           </tr></table>
               <table> <tr>   
                   <td><input type="submit" name="update" value="Update Store"   onclick="form.action='loadstorecontroller';"/></td>
    				<td><input type="submit" name="delete" value="Delete Store"  onclick="form.action='deletestorecontroller';"/></td>
    				<td><input type="submit" name="manager" value="Manager Details"  onclick="form.action='loadstoremanagercontroller';"/></td>
    				</tr>
           </table>         
           </center>
                   
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
  </div>
</div>
<div id="footer">
    <div id="r"> &copy; Copyright 2016, Your Website - <a href="AdminHome.jsp">Home</a> - <a href="InitialPage.jsp">Logout</a><br />
      Design: SSDI project1</div>
    <div id="l">Contact us: Office-000-000-0000 </div>
  </div>
  
  </div>
</body>
</html>
