package webapp;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {

	 String sql= "select * from istassess.users where username=? and userpassword=md5(?)";
     String usern = "";	 
     String imgPath = "";	
  
     public boolean check(String uname, String pass) {
		 
		try {
			
			DatabaseConnect db = new DatabaseConnect();
			
			PreparedStatement st = db.getConnection(sql);
			
			System.out.println(uname + "  "+ pass);
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs = st.executeQuery();
		
			if(rs.next()) {
				
			usern =	rs.getString("firstName");
			imgPath = rs.getString("userImagePath") ;
				
			db.closeConnection();
			rs.close();
			
			
				return true;
			}
			
		} catch (Exception e)  {
			
			e.printStackTrace();
		}
		
		 
		 		return false;
		
	 }
	 
	ArrayList<String> getUserRoles(String username) throws ClassNotFoundException, SQLException {
		
		sql = "select r.roleName from users u, userroles ur, roles r where u.username = ur.userid and ur.roleid = r.roleid  and username=?";
		
		ArrayList<String> userRoles  =  new ArrayList<String>();
		
		DatabaseConnect db = new DatabaseConnect();
		PreparedStatement st = db.getConnection(sql);
		
		st.setString(1, username);
			
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			userRoles.add(rs.getString("roleName"));
		
		}
		db.closeConnection();
		rs.close();
		
		return userRoles;
		
		
		
	}
	
    ArrayList<String> getTerm() throws ClassNotFoundException, SQLException {
		
		sql = "select * from terms";
		
		ArrayList<String> terms  =  new ArrayList<String>();
		
		DatabaseConnect db = new DatabaseConnect();
		PreparedStatement st = db.getConnection(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			terms.add(rs.getString("term"));
		
		}
		db.closeConnection();
		rs.close();
		
		return terms;
		
		
		
	}   
	 
}
