package webapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Report.do")
public class ReportSectionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		String section=request.getParameter("parm1");  
		
		String sec[] = section.split("\\|");
		System.out.println(sec[3]);
		
		
		try {
			ReportSectionDao rd =  new ReportSectionDao();
			rd.getSectionReport(sec);
			
			request.setAttribute("ins",rd.getInstrument());
			request.setAttribute("desc",rd.getOutcomeDescription());
			request.setAttribute("sec",rd.getSection());
			request.getRequestDispatcher("/WEB-INF/views/report.jsp").forward(request, response);	
			System.out.println("aakash");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}