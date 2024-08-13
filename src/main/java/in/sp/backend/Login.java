package in.sp.backend;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import in.sp.dao.UserDAO;
import in.sp.dao.impl.UserDAOImpl;
import in.sp.model.UserModel;

@WebServlet("/LoginForm")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public Login() {
		super();
		userDAO = new in.sp.dao.impl.UserDAOImpl(); // Initialize DAO
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String myemail = request.getParameter("email1");
		String mypass = request.getParameter("pass1");

		try {
			UserModel user = userDAO.getUserByEmailAndPassword(myemail, mypass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("session_user", user);

				out.print("<h3 style='color:green'><br><br>Login Successful</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			} else {
				out.print("<h3 style='color:red'>Email id and password didn't match</h3> <br><br>");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("<h3 style='color:red'>" + e.getMessage() + "</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}
}
