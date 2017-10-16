package webapp;

import java.sql.*;
import java.util.ArrayList;

public class ReportSectionDao {

	 String url = "jdbc:mysql://localhost/istassess";
	 String username = "root";
	 String password = "Aakash00@@";
	 Connection con;
	 
	 String ins;
	 String desc;
	 String section[];
    	 
	PreparedStatement getConnection(String sql) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		
		return st;
			
	}
	
	 
	void getSectionReport(String sec[]) throws ClassNotFoundException, SQLException {
		
		String sql = "select instrument,outcomeDescription from evaluations where courseNumber = ?  and programName = ?";
		section = sec;
		ArrayList<String> sections  =  new ArrayList<String>();
		PreparedStatement st = getConnection(sql);
		
		st.setString(1, sec[0].trim());
		st.setString(2, sec[3].trim());
			
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			ins = rs.getString("instrument");
			desc = rs.getString("outcomeDescription");
		
		}
		con.close();
		rs.close();
					
	}
	
	String getInstrument(){
		
	return ins;	
	}
	String getOutcomeDescription(){
		
		return desc;	
		}
	
	String getSection(){
		
		
	
	return section[0]+ '~' + section[1] + '~' +section[2]+ '~' +section[3];	
	}
}
	 

