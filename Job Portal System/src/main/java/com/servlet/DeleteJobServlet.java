package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DB.DBConnect;

import com.dao.*;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			JobDAO dao = new JobDAO(DBConnect.getConnection());
			boolean f = dao.deleteJobs(id);
			HttpSession session = request.getSession();
			
			if (f) {
				session.setAttribute("succMsg", "Job Delete SuccessFully");
				response.sendRedirect("view_job.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				response.sendRedirect("view_job.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
