package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/section.do")
public class SectionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		//System.out.println("aakash");
		
		  String name=request.getParameter("InputUserName1");  
	      String role=request.getParameter("Role"); 
	      String term=request.getParameter("Term"); 
	     System.out.println(request.getParameter("name"));
		
		
	     SectionDao sd = new SectionDao();
	    
		
	        try {
				//System.out.println(sd.getUserSection(name,role));
	        	
						
			request.setAttribute("section",sd.getUserSection(name,role,term));
			request.setAttribute("programHostName",sd.getProgramHostName());
			request.setAttribute("term",term);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);	
		}
		
	

}