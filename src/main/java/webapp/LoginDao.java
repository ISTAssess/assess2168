package webapp;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {

	 String url = "jdbc:mysql://localhost/istassess";
	 String username = "root";
	 String password = "Aakash00@@";
	 String sql= "select * from istassess.users where username=? and userpassword=md5(?)";
     String usern = "";	 
     String imgPath = "";	
     Connection con;
     public boolean check(String uname, String pass) {
		 
		try {
			
			PreparedStatement st = getConnection(sql);
			
			System.out.println(uname + "  "+ pass);
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs = st.executeQuery();
		
			if(rs.next()) {
				
			usern =	rs.getString("firstName");
			imgPath = rs.getString("userImagePath") ;
				
			con.close();
			rs.close();
			
			
				return true;
			}
			
		} catch (Exception e)  {
			
			e.printStackTrace();
		}
		
		 
		 		return false;
		
	 }
	 
	PreparedStatement getConnection(String sql) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		
		return st;
			
	}
	
	 
	ArrayList<String> getUserRoles(String username) throws ClassNotFoundException, SQLException {
		
		sql = "select r.roleName from users u, userroles ur, roles r where u.username = ur.userid and ur.roleid = r.roleid  and username=?";
		
		ArrayList<String> userRoles  =  new ArrayList<String>();
		PreparedStatement st = getConnection(sql);
		
		st.setString(1, username);
			
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			userRoles.add(rs.getString("roleName"));
		
		}
		con.close();
		rs.close();
		
		return userRoles;
		
		
		
	}
	 
}
