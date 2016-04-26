package util.db.connection;

public interface IConnectionData {
	public String getDriver();
	public String getDBURL();
	public String getUserName();
	public String getPassword();
}
