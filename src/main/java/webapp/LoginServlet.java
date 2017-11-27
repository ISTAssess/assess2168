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

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// System.out.println("aakash");

		String name = request.getParameter("InputUserName1");
		String password = request.getParameter("InputPassword1");

		LoginDao dao = new LoginDao();

		if (dao.check(name, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", dao.usern);
			session.setAttribute("username", name);
			session.setAttribute("path", dao.imgPath);
			System.out.println(dao.imgPath);

			try {
				System.out.println();

				session.setAttribute("userRoles", dao.getUserRoles(name));

				session.setAttribute("terms", dao.getTerm());

				// session.setAttribute("userRoles",sd.getUserSection(name));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		} else {

			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		}

	}

}