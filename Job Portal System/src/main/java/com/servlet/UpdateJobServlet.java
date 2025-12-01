package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DB.DBConnect;
import com.entity.Jobs;
import com.dao.JobDAO;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String location = request.getParameter("location");
			String category = request.getParameter("category");
			String status = request.getParameter("status");
			String description = request.getParameter("desc");
			
			Jobs j = new Jobs();
			j.setId(id);
			j.setTitle(title);
			j.setDescription(description);
			j.setLocation(location);
			j.setStatus(status);
			j.setCategory(category);
			
			HttpSession session = request.getSession();
			
			JobDAO dao = new JobDAO(DBConnect.getConnection());
			boolean f = dao.updateJob(j);
			if (f) {
				session.setAttribute("succMsg", "Job Update SuccessFully");
				response.sendRedirect("view_job.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				response.sendRedirect("view_job.jsp");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
