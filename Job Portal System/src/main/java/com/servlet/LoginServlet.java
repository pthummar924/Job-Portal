package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DB.DBConnect;
import com.entity.User;
import com.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			String em = request.getParameter("email");
			String ps = request.getParameter("password");
			
			User user = new User();
			HttpSession session = request.getSession();
			if ("admin@gmail.com".equals(em) && "admin123".equals(ps)) {
				session.setAttribute("userobj", user);
				user.setRole("admin");
				response.sendRedirect("admin.jsp");
			} else {
				UserDAO dao = new UserDAO(DBConnect.getConnection());
				User u = dao.login(em, ps);
				
				if (u != null) {
					session.setAttribute("userobj", u);
					response.sendRedirect("home.jsp");
				} else {
					session.setAttribute("succMsg", u);
					response.sendRedirect("login.jsp");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
