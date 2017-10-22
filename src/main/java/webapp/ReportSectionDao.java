package webapp;

import java.sql.*;
import java.util.ArrayList;

public class ReportSectionDao {

	 
	 String ins;
	 String desc;
	 String section[];
    	 

	 
	void getSectionReport(String sec[]) throws ClassNotFoundException, SQLException {
		
		String sql = "select instrument,outcomeDescription from evaluations where courseNumber = ?  and programName = ?";
		section = sec;
		ArrayList<String> sections  =  new ArrayList<String>();
		
		DatabaseConnect db = new DatabaseConnect();
		
		PreparedStatement st = db.getConnection(sql);
		
		st.setString(1, sec[0].trim());
		st.setString(2, sec[3].trim());
			
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			ins = rs.getString("instrument");
			desc = rs.getString("outcomeDescription");
		
		}
		db.closeConnection();
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
	 

