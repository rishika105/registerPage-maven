package in.sp.backend;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.sp.dao.UserDAO;
import in.sp.dao.impl.UserDAOImpl;
import in.sp.model.UserModel;

@WebServlet("/regForm")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public Register() {
        super();
        userDAO = new UserDAOImpl(); // Initialize DAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String myname = request.getParameter("name1");
        String myemail = request.getParameter("email1");
        String mypass = request.getParameter("pass1");
        String mygender = request.getParameter("gender1");
        String mycity = request.getParameter("city1");

        UserModel user = new UserModel();
        user.setName(myname);
        user.setEmail(myemail);
        user.setPassword(mypass);
        user.setGender(mygender);
        user.setCity(mycity);

        try {
            boolean isRegistered = userDAO.registerUser(user);
            if (isRegistered) {
    out.print("<h3 style='color:green'> User Registered Successfully </h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            } else {
                out.print("<h3 style='color:red'> User Not Registered</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3 style='color:red'> Exception: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.include(request, response);
        }
    }
}
