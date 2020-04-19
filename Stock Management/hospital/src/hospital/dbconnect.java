package hospital;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {
	public static Connection connect() {
	    Connection conn=null;
	    	
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("conection "+e);
			}
	    	
	    	return conn;
	    	
	    }
}
