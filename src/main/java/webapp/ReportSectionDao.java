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
	
	ArrayList<String> checkSecReported(String courseNum, String sectionNum, String progName, String term) throws SQLException, ClassNotFoundException
	{
		
		String sql= "select gradesOutOf,grades from SectionsReported where courseNumber = ?"
				    + " and sectionNumber = ?"
				    + " and programName = ?"
				    + " and term  = ?";
		DatabaseConnect db = new DatabaseConnect();
		
		PreparedStatement st = db.getConnection(sql);
		ArrayList<String> secResult  =  new ArrayList<String>();
		st.setString(1, courseNum);
		st.setString(2, sectionNum);
		st.setString(3, progName);
		st.setString(4, term);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			
			int gradeInt = (int)rs.getDouble("gradesOutOf");
			
			secResult.add(String.valueOf(gradeInt));
			secResult.add(rs.getString("grades"));
			db.closeConnection();
			rs.close();
			return secResult;
		
		}
		else {
			db.closeConnection();
			rs.close();
			return secResult;
		}
		}
		
		
	}


	 

