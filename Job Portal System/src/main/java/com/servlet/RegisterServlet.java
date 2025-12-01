package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DB.DBConnect;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/add_user")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String qua = request.getParameter("qua");
			String email = request.getParameter("email");
			String ps = request.getParameter("ps");
			
			UserDAO dao = new UserDAO(DBConnect.getConnection());
			
			User user = new User(name, email, ps, qua, "User");
			boolean f = dao.addUser(user);
			HttpSession session = request.getSession();
			
			if (f) {
				session.setAttribute("succMsg", "Register SuccessFully");
				response.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				response.sendRedirect("signup.jsp");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
