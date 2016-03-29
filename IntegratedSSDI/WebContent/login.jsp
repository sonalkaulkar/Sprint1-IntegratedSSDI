<%-- 
    Document   : addProperty
    Created on : Feb 23, 2016, 11:30:40 AM
    Author     : skaul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Property</title>
    </head>
    <body>
       <form  method = "post" action="logincontroller">
       
           <table align="center" >
               <center><h1> Login Details </h1></center>
               <tr>
               <td> Login id:</td>
               <td><input type="text" name="login_id" value="" /></td>
               </tr>
               <tr>
                   <td>Password:</td>
                   <td><input type="password" name="password" value="" /></td>
                 </tr>
                  <tr>
               <td></td>
               <td> <input type="submit" value="Login" /></td>
               
           </tr>
           </table>
</form>
    </body>
</html>
