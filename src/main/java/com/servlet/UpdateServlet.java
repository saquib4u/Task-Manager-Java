package com.servlet;

import java.io.IOException;

import com.DAO.TaskDAO;
import com.db.DBConnect;
import com.entity.TaskDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String task = req.getParameter("task");
		String status = req.getParameter("status");
		
		TaskDAO dao = new TaskDAO(DBConnect.getConn());
		
		TaskDetails t=new TaskDetails();
		t.setId(id);
		t.setName(username);
		t.setTask(task);
		t.setStatus(status);
		
		boolean f=dao.updateTask(t);
		
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("successMsg", "Task updated sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Something went wrong. Unable to update task.");
			resp.sendRedirect("index.jsp");
		}
	}
	
}
