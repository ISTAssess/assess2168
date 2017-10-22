package webapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class InsertSecDao {

	 
	 int perc;
	 
	 String ins;
	 String desc;
	 String section[];
    	 
	 
	void setSectionReport(String sec,String outOf, String grades) throws ClassNotFoundException, SQLException {
		
		String secsplit[] = sec.split("\\~");
		
		Calendar currenttime = Calendar.getInstance();
	    Date sqldate = new Date((currenttime.getTime()).getTime());
		
		String sql = "select percentageofstudents from evaluations where courseNumber = ?  and programName = ?";
		
		DatabaseConnect db = new DatabaseConnect();
		
		PreparedStatement st = db.getConnection(sql);
				
		st.setString(1, secsplit[0].trim());
		st.setString(2, secsplit[3].trim());

		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			perc = rs.getInt("percentageofstudents");
		
		}
		
		rs.close();
		int count=0;
		int metCount =0;
		String[] lines = grades.split("\r\n|\r|\n");
		for (String line : lines) {
			if(Integer.parseInt(line)>= perc)
				metCount++;
			count++;
		}
		
		String insertTableSQL = "INSERT INTO SectionsReported"
				+ " VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		st = db.getConnection(insertTableSQL);
		
		System.out.println(secsplit[3].trim());
		
		st.setString(1, secsplit[0].trim());
		st.setString(2, secsplit[1].trim());
		st.setString(3, secsplit[3].trim());
		st.setString(4, "2165");
		st.setInt(5, count);
		st.setInt(6, metCount);
		st.setDate(7, sqldate);
		st.setDouble(8, Double.valueOf(outOf));
		st.setString(9, grades);
		
		
		st.executeUpdate();
		db.closeConnection();
		
		
					
	}
	
	String getInstrument(){
		
	return ins;	
	}
	String getOutcomeDescription(){
		
		return desc;	
		}
	
	String getSection(){
		
		
	
	return section[0]+ '-' + section[1] + '-' +section[2]+ '-' +section[3];	
	}
}
	 

