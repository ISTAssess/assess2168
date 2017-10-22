package webapp;

import java.sql.*;
import java.util.ArrayList;

public class SectionDao {

	 
	 ArrayList<String> programHostName  =  new ArrayList<String>();
    	 
	 
	ArrayList<String> getUserSection(String username, String role) throws ClassNotFoundException, SQLException {
		
		String sql = "select c.coursenumber, s.sectionnumber, c.coursename , e.programname from sections s, courses c, evaluations e " +
					"where  s.coursenumber = c.coursenumber and  e.coursenumber  = c. coursenumber and " + 
					" s.instructor = ?  and s.term >= ? "; 
		
		ArrayList<String> sections  =  new ArrayList<String>();
		DatabaseConnect db = new DatabaseConnect();
		PreparedStatement st = db.getConnection(sql);
		st.setString(1, username);
		st.setString(2, "2165");
			
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			sections.add(rs.getString("coursenumber")+ " | " + rs.getString("sectionnumber") + " | " + rs.getString("coursename").replaceAll("&", "and")+ " | " + rs.getString("programname"));
			//programHostName.add(rs.getString("programhostname"));
		}
		db.closeConnection();
		rs.close();
		
		
		return sections;
		
		
		
	}
	
	ArrayList<String> getProgramHostName(){
		
	return programHostName;	
	}
	}
	 

