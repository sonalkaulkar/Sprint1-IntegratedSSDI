package model;

public class Login {
String username ,password;
public Login() {
	// TODO Auto-generated constructor stub
}

public Login(String user ,String pass)
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

}
