package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class Admin implements User {
String username ,password;
public Admin() {
	// TODO Auto-generated constructor stub
}

public Admin(String user ,String pass)
{
	username = user ;
	password = pass;
	
}
public String getPassword() {
	return password;
}
public String getUsername() {
	return username;
}
public void setPassword(String password) {
	this.password = password;
}

public void setUsername(String username) {
	this.username = username;
}
public RequestDispatcher directUser(HttpServletRequest request) {
	// TODO Auto-generated method stub
    RequestDispatcher r = request.getRequestDispatcher("/AdminHome.jsp") ;
    return r;
}

}
