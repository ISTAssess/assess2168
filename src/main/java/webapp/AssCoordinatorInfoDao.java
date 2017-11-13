package webapp;

import java.sql.*;
import java.util.ArrayList;

public class AssCoordinatorInfoDao {

	 
	 ArrayList<String> programHostName  =  new ArrayList<String>();
    	 
	 
	ArrayList<String> getInfo(String term) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT  sr.programname 'Program'," + 
         " s.coursenumber 'Course', s.sectionnumber 'Section', c.coursename," +
        " sr.gradesreportedcount as '# reported', sr.benchmarkmetcount as '# met/exceed'," + 
        " CONCAT(FORMAT(sr.benchmarkmetcount / sr.gradesreportedcount * 100,0),'%') as Percent," +
        " e.outcomedescription, e.instrument," + 
        " e.percentageofstudents as '% of', e.meetorexceedpercentage as 'meet/exceed'" +
	    " from sections as s left join evaluations as e using (coursenumber)" +
	    " left join sectionsreported as sr using (coursenumber,programname)" +
	    " left join courseclassification as cc using (coursenumber, programname)" +
	    " join courses as c using (coursenumber) where s.term in (?)" + 
	    " AND s.term = sr.term AND cc.ismiddlestates = true" +
	    " order by sr.programname, s.coursenumber, s.sectionnumber;";
			
		System.out.println(term);
		ArrayList<String> info  =  new ArrayList<String>();
		DatabaseConnect db = new DatabaseConnect();
		PreparedStatement st = db.getConnection(sql);
		st.setString(1, term);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			
				
		info.add(rs.getString("Program")+ " | " + rs.getString("Course")+ " | " + rs.getString("Section") + " | " 
		+ rs.getString("coursename").replaceAll("&", "and")+ " | " 
		+ rs.getInt("# reported")+ " | " + rs.getInt("# met/exceed")+ " | "
		+ rs.getString("Percent")+ " | "  + rs.getString("outcomedescription")+ " | "
		+ rs.getString("instrument")+ " | "
		+ rs.getBigDecimal("% of")+" | " + rs.getBigDecimal("meet/exceed"));
			
		}
		
		
		db.closeConnection();
		rs.close();
		
		
		return info;
		
		
	}
	}
	
	

