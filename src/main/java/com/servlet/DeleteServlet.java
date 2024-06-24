package com.servlet;

import java.io.IOException;

import com.DAO.TaskDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TaskDAO dao = new TaskDAO(DBConnect.getConn());
		boolean f = dao.deleteTask(id);
		
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("successMsg", "Task deleted sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Something went wrong. Unable to delete task.");
			resp.sendRedirect("index.jsp");
		}
	}
	
}
