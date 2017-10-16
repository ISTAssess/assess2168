package webapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/insert.do")
public class InsertSecServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		String outOf=request.getParameter("outOf");  
		
		
		String grades=request.getParameter("enterGrades");  
		
	
        String sec=request.getParameter("sec");  
        String secsplit[] = sec.split("\\|");
		
        
        try {
        	InsertSecDao isd = new InsertSecDao();
			isd.setSectionReport(secsplit[0],outOf,grades);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		

	    request.setAttribute("ins",secsplit[1]);
		request.setAttribute("desc",secsplit[2]);
		request.setAttribute("sec",secsplit[0]);
		request.setAttribute("status","Grades Reported Successfully");
		request.getRequestDispatcher("/WEB-INF/views/report.jsp").forward(request, response);
		
		
		
		
	}
	

}