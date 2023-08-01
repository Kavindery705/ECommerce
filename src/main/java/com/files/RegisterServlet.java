package com.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.files.entities.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name=request.getParameter("uname");
		String email=request.getParameter("uemail");
		String password = request.getParameter("upassword");
		long phone = Long.parseLong(request.getParameter("uphone"));
		String address=request.getParameter("uaddress");
		
		User user= new User(name, email, password, phone, "default.jpg", address,"normal");
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		int uid = (int)s.save(user);
		tx.commit();
		s.close();
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("message", "Registeration Successful"+uid);
		response.sendRedirect("register.jsp");
		pw.print("successfully saved");
		pw.print("<br>User Id is"+uid);
		return;
				
		
	}

}
