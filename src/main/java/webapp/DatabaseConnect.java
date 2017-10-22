package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnect {
	
	
	String url = "jdbc:mysql://localhost/istassess";
	String username = "root";
	String password = "Aakash00@@";
	Connection con;
	 
	 
	 PreparedStatement getConnection(String sql) throws SQLException, ClassNotFoundException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			
			return st;
				
		}
	 
	 void closeConnection() throws SQLException
	 {
		 con.close();
	 }
}

