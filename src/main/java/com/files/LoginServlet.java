package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.entities.User;
import com.files.entities.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		UserDao db = new UserDao(FactoryProvider.getFactory());
		User user = db.getUserByemailpass(email, password);
		HttpSession session = request.getSession();
		if(user!=null) {
			
			session.setAttribute("message", "Successful logged in "+user.getUname());
			session.setAttribute("current-user", user);
			if(user.getType().equals("admin")) {
				response.sendRedirect("admin.jsp");
			}
			else if(user.getType().equals("normal")) {
				
				response.sendRedirect("normal.jsp");
			}
			else {
				session.setAttribute("message", "not identified user type");
				response.sendRedirect("login.jsp");
			}
		}
		else
		{
			session.setAttribute("message", "Invalid details!");
			response.sendRedirect("login.jsp");
		}
		
	}

}
