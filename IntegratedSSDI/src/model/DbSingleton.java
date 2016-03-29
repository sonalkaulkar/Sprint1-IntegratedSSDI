package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class DbSingleton {
    private static String db_url;
    private static String db_port;
    private static String db_name;
    private static String db_user;
    private static String db_password;
    private static Connection connection;

    private DbSingleton() {
/* 
       *Default database parameters 
*/
        db_url = "jdbc:mysql://127.0.0.1";
        db_port = "3306";
        db_name = "ssdi";
        db_user = "root";
        db_password = "UnccSonal11";
/* Creation of an instance of the connection statement*/
        connection = setConnection();
    }
/* Private method charge to set the connection statement*/
    private static Connection setConnection() {
        try {
        	  Class.forName("com.mysql.jdbc.Driver");
            String url = "" + db_url + ":" + db_port + "/" + db_name + "";
            Connection conn = DriverManager.getConnection(url, db_user, db_password);

            //Creation of the Statement object
           // java.sql.Statement state = conn.createStatement();
            return  conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

/* Private inner class responsible for instantiating the single instance of the singleton */
    private static class DbSingletonManagerHolder {
        private final static DbSingleton instance = new DbSingleton();
    }

    /**
     * @return
Public method, which is the only method allowed to return an instance of 
the singleton (the instance here is the database connection statement)
     */
    public static DbSingleton getInstance() {
        try {
            return DbSingletonManagerHolder.instance;
        } catch (ExceptionInInitializerError ex) {

        }
        return null;
    }
    public static Connection getStatement() {
        return connection;
    }
}
 
