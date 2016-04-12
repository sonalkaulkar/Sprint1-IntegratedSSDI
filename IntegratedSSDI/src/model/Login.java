package model;

public class Login {
String username ,password; 
int roleid;
public Login() {
	// TODO Auto-generated constructor stub
}

public Login(String user ,String pass, int roleid)
{
	username = user ;
	password = pass;
	this.roleid = roleid;
	
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
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
